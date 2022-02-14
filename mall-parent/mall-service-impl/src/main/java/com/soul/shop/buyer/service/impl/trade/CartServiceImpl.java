package com.soul.shop.buyer.service.impl.trade;

import com.soul.shop.buyer.service.CartService;
import com.soul.shop.buyer.service.GoodsSkuService;
import com.soul.shop.buyer.service.impl.CacheService;
import com.soul.shop.common.enums.BusinessCodeEnum;
import com.soul.shop.common.utils.CurrencyUtil;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.enums.CartTypeEnum;
import com.soul.shop.model.buyer.enums.goods.GoodsAuthEnum;
import com.soul.shop.model.buyer.enums.goods.GoodsStatusEnum;
import com.soul.shop.model.buyer.pojo.goods.GoodsSku;
import com.soul.shop.model.buyer.vo.trade.CartSkuVO;
import com.soul.shop.model.buyer.vo.trade.CartVO;
import com.soul.shop.model.buyer.vo.trade.TradeVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@DubboService(version = "1.0.0", interfaceClass = CartService.class)
public class CartServiceImpl implements CartService {

    @Autowired
    private GoodsSkuService goodsSkuService;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private TradeBuilder tradeBuilder;

    /**
     * 1. userId为null, 用户未登录直接返回
     * 2. 检测商品的有效性，商品是否存在，有效，库存是否足 GoodsSku
     * 3. TradeVO 构建购物车视图，购物车的数据，放入缓存中
     * 4. 先从缓存中获取购物车数据，如果没有，进行新的添加操作
     * 5. 如果有，在原有的基础山进行添加
     * 6. 添加购物车的目的是为了CartSkuVO对象，构建goodsSku,数量，计算金额
     * 7. 把购物车对象添加到redis中
     *
     * @param cartTypeEnum
     * @param skuId
     * @param num
     * @param userId
     * @return
     */
    @Override
    public Result<Object> addCart(CartTypeEnum cartTypeEnum, String skuId, Integer num, String userId) {
        if (userId == null) {
            return Result.fail(BusinessCodeEnum.HTTP_NO_LOGIN.getCode(), BusinessCodeEnum.HTTP_NO_LOGIN.getMsg());
        }
        Result<Object> goodsResult = this.checkGoods(skuId, num);
        if (!goodsResult.isSuccess()) {
            return goodsResult;
        }
        GoodsSku goodsSku = (GoodsSku) goodsResult.getResult();

        if (CartTypeEnum.CART.equals(cartTypeEnum)) {
            TradeVO tradeVO = this.createTradeVO(cartTypeEnum, userId);
            List<CartSkuVO> skuList = tradeVO.getSkuList();
            // 购物车sku商品是否为空，如果为空，新建
            if (CollectionUtils.isEmpty(skuList)) {
                this.addGoodsToCart(num, goodsSku, skuList, cartTypeEnum);
            } else {
                // 判断当前购物车中有没有和我当前加入购物车一样的商品，如果一样，数量叠加
                CartSkuVO cartSkuVO =
                        skuList.stream()
                                .filter(i -> i.getGoodsSku().getId().equals(goodsSku.getId()))
                                .findFirst()
                                .orElse(null);
                if (cartSkuVO == null) {
                    this.addGoodsToCart(num, goodsSku, skuList, cartTypeEnum);
                } else {
                    // 如果购物车中的商品的更新时间和当前拿到的商品的更新时间不一样，证明此商品修改过，也就是过期了，应该进行重新添加
//                    if (true) {
                    if (cartSkuVO.getGoodsSku().getUpdateTime().equals(goodsSku.getUpdateTime())) {
                        Integer oldNum = cartSkuVO.getNum();
                    // 需要做库存的判断
                    int newNum = oldNum + num;
                    if (newNum > goodsSku.getQuantity()) {
                        return Result.fail(-999, "库存不足");
                    }
                    cartSkuVO.setNum(newNum);
                    cartSkuVO.setSubTotal(CurrencyUtil.mul(cartSkuVO.getPurchasePrice(), newNum));
                    skuList.remove(cartSkuVO);
                    skuList.add(cartSkuVO);
                } else{
                    skuList.remove(cartSkuVO);
                    addGoodsToCart(num, goodsSku, skuList, cartTypeEnum);
                }
            }
        }
        cacheService.set(CartTypeEnum.CART.name() + "_" + userId, tradeVO, null);
    }
        return Result.success();
}

    /**
     * 1. 写一个Trade构建类，根据不同的需求，进行不同的购物车渲染
     * @param cartTypeEnum
     * @param userId
     * @return
     */
    @Override
    public Result<TradeVO> buildAllTrade(CartTypeEnum cartTypeEnum, String userId) {
        TradeVO tradeVO = tradeBuilder.buildCart(createTradeVO(cartTypeEnum, userId));
        log.info("finish buildAllTrade with return tradeVO: {}", tradeVO.toString());
        return Result.success(tradeVO);
    }

    @Override
    public Result<Integer> countGoodsInTrade(CartTypeEnum cartTypeEnum, String userId) {
        TradeVO tradeVO = tradeBuilder.buildCart(createTradeVO(cartTypeEnum, userId));
        int count = 0;
        for (CartVO cartVO : tradeVO.getCartList()) {
            for (CartSkuVO cartSkuVO : cartVO.getSkuList()) {
                count += cartSkuVO.getNum();
            }
        }
        return Result.success(count);
    }

    private void addGoodsToCart(Integer num, GoodsSku goodsSku, List<CartSkuVO> skuList, CartTypeEnum cartTypeEnum) {
        CartSkuVO cartSkuVO = new CartSkuVO(goodsSku);
        cartSkuVO.setNum(num);
        cartSkuVO.setSubTotal(CurrencyUtil.mul(cartSkuVO.getPurchasePrice(), num));
        cartSkuVO.setCartType(cartTypeEnum);
        skuList.add(cartSkuVO);
    }

    /**
     * 把购物车数据从缓存拿, 如果缓存中没有就构建新的购物车数据
     *
     * @param cartTypeEnum
     * @param userId
     * @return
     */
    private TradeVO createTradeVO(CartTypeEnum cartTypeEnum, String userId) {
        TradeVO tradeVO = cacheService.get(CartTypeEnum.CART.name() + "_" + userId, TradeVO.class);
        if (tradeVO == null) {
            tradeVO = new TradeVO();
            tradeVO.init(cartTypeEnum);
        }
        return tradeVO;
    }

    private Result<Object> checkGoods(String skuId, Integer num) {
        GoodsSku goodsSku = goodsSkuService.findGoodsSkuById(skuId);
        if (goodsSku == null) {
            return Result.fail(-999, "商品不存在");
        }
        if (GoodsAuthEnum.PASS.getCode() != goodsSku.getIsAuth()) {
            return Result.fail(-999, "商品未审核通过");
        }
        if (GoodsStatusEnum.UPPER.getCode() != goodsSku.getMarketEnable()) {
            return Result.fail(-999, "商品已下架");
        }
        Integer quantity = goodsSku.getQuantity();
        if (num > quantity) {
            return Result.fail(-999, "库存不足");
        }
        return Result.success(goodsSku);
    }
}
