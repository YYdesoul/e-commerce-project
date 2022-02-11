package com.soul.shop.buyer.service.impl.trade.domain;

import com.soul.shop.buyer.service.GoodsSkuService;
import com.soul.shop.common.utils.CurrencyUtil;
import com.soul.shop.model.buyer.enums.goods.GoodsAuthEnum;
import com.soul.shop.model.buyer.enums.goods.GoodsStatusEnum;
import com.soul.shop.model.buyer.pojo.goods.GoodsSku;
import com.soul.shop.model.buyer.vo.trade.CartSkuVO;
import com.soul.shop.model.buyer.vo.trade.CartVO;
import com.soul.shop.model.buyer.vo.trade.TradeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Order(0)
@Slf4j
public class CheckDataRender implements CartRenderStep{

    @Autowired
    private GoodsSkuService goodsSkuService;

    @Override
    public void render(TradeVO tradeVO) {
        // 校验商品有效性
        checkData(tradeVO);
        // 店铺分组数据初始化
        groupStore(tradeVO);
    }

    private void groupStore(TradeVO tradeVO) {
        List<CartVO> cartVOList = new ArrayList<>();
        // 根据店铺分组
        Map<String, List<CartSkuVO>> storeCollect = tradeVO.getSkuList()
                .parallelStream()
                .collect(Collectors.groupingBy(CartSkuVO::getStoreId));
        for (Map.Entry<String, List<CartSkuVO>> storeCart : storeCollect.entrySet()) {
            if (!storeCart.getValue().isEmpty()) {
                CartVO cartVO = new CartVO(storeCart.getValue().get(0));
                cartVO.setSkuList(storeCart.getValue());
                storeCart.getValue()
                        .stream()
                        .filter(i -> Boolean.TRUE.equals(i.getChecked()))
                        .findFirst()
                        .ifPresent(cartSkuVO -> cartVO.setChecked(true));
                cartVOList.add(cartVO);
            }
        }
        tradeVO.setCartList(cartVOList);
        log.info("finish method groupStore");
    }

    /**
     * 1. 获取购物车的商品信息
     * 2. 校验商品是否过期
     * 3. 校验商品是否已下架
     * 4. 校验商品是否库存足
     * 5. 计算商品的价格 价格*数量
     *
     * @param tradeVO
     */
    private void checkData(TradeVO tradeVO) {
        List<CartSkuVO> skuList = tradeVO.getSkuList();
        for (CartSkuVO cartSkuVO : skuList) {
            GoodsSku goodsSku = cartSkuVO.getGoodsSku();
            Long goodsSkuId = goodsSku.getId();
            GoodsSku dataGoodSku = goodsSkuService.findGoodsSkuById(String.valueOf(goodsSkuId));
            if (dataGoodSku == null || dataGoodSku.getUpdateTime().compareTo(goodsSku.getUpdateTime()) != 0) {
                // 商品信息发生了变化，认为此商品不合法
                setCartSkuVOInvalid(cartSkuVO, "商品信息发生变化，已失效");
                continue;
            }
            if (GoodsAuthEnum.PASS.getCode() != dataGoodSku.getIsAuth() ||
                    GoodsStatusEnum.UPPER.getCode() != dataGoodSku.getMarketEnable()) {
                setCartSkuVOInvalid(cartSkuVO, "商品已下架");
                continue;
            }
            if (dataGoodSku.getQuantity() < cartSkuVO.getNum()) {
                setCartSkuVOInvalid(cartSkuVO, "商品库存不足");
                continue;
            }
            // 写入初始价格
            cartSkuVO.getPriceDetailDTO().setGoodsPrice(CurrencyUtil.mul(cartSkuVO.getPurchasePrice(), cartSkuVO.getNum()));
        }
    }

    private void setCartSkuVOInvalid(CartSkuVO cartSkuVO, String message) {
        cartSkuVO.setChecked(false);
        cartSkuVO.setInvalid(true);
        cartSkuVO.setErrorMessage(message);
    }
}
