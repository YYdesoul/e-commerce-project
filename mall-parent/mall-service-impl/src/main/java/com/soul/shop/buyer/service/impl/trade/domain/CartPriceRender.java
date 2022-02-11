package com.soul.shop.buyer.service.impl.trade.domain;

import com.soul.shop.buyer.service.CategoryService;
import com.soul.shop.common.utils.CurrencyUtil;
import com.soul.shop.model.buyer.dtos.trade.PriceDetailDTO;
import com.soul.shop.model.buyer.vo.trade.CartSkuVO;
import com.soul.shop.model.buyer.vo.trade.CartVO;
import com.soul.shop.model.buyer.vo.trade.TradeVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车渲染，将购物车中的各个商品拆分到每个商家，形成购物车VO
 */
@Order(5)
@Service
public class CartPriceRender implements CartRenderStep{

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 计算购物车商品数量
     * 2. 计算购物车的价格（选中的）
     * 3. 计算整个交易的总价（选中的）
     *
     * @param tradeVO
     */
    @Override
    public void render(TradeVO tradeVO) {
        this.buildCart(tradeVO);
        this.buildCartPrice(tradeVO);
        this.buildTradePrice(tradeVO);
    }

    /**
     * 购物车价格
     *
     * @param tradeVO 购物车展示信息
     */
    private void buildCartPrice(TradeVO tradeVO) {
        List<CartSkuVO> cartSkuVOList = tradeVO.getSkuList();
        //购物车列表
        List<CartVO> cartVOS = tradeVO.getCartList();

        //key store id
        //value 商品列表
        Map<String, List<CartSkuVO>> map = new HashMap<>();
        for (CartSkuVO cartSkuVO : cartSkuVOList) {
            //如果存在商家id
            if (map.containsKey(cartSkuVO.getGoodsSku().getStoreId())) {
                List<CartSkuVO> list = map.get(cartSkuVO.getGoodsSku().getStoreId());
                list.add(cartSkuVO);
            } else {
                List<CartSkuVO> list = new ArrayList<>();
                list.add(cartSkuVO);
                map.put(cartSkuVO.getGoodsSku().getStoreId(), list);
            }
        }

        //计算购物车价格
        for (CartVO cart : cartVOS) {
            List<CartSkuVO> cartSkuVOS = map.get(cart.getStoreId());
            List<PriceDetailDTO> priceDetailDTOS = new ArrayList<>();
            if (Boolean.TRUE.equals(cart.getChecked())) {
                //累加价格
                for (CartSkuVO cartSkuVO : cartSkuVOS) {
                    if (Boolean.TRUE.equals(cartSkuVO.getChecked())) {
                        PriceDetailDTO priceDetailDTO = cartSkuVO.getPriceDetailDTO();
                        //流水金额(入账 出帐金额) = goodsPrice + freight - discountPrice - couponPrice
                        double flowPrice = CurrencyUtil.sub(CurrencyUtil.add(priceDetailDTO.getGoodsPrice(), priceDetailDTO.getFreightPrice()), CurrencyUtil.add(priceDetailDTO.getDiscountPrice(), priceDetailDTO.getCouponPrice() != null ? priceDetailDTO.getCouponPrice() : 0));
                        priceDetailDTO.setFlowPrice(flowPrice);

                        //最终结算金额 = flowPrice - platFormCommission - distributionCommission
                        double billPrice = CurrencyUtil.sub(CurrencyUtil.sub(flowPrice, priceDetailDTO.getPlatFormCommission()), priceDetailDTO.getDistributionCommission());
                        priceDetailDTO.setBillPrice(billPrice);

                        //平台佣金
                        String categoryId = cartSkuVO.getGoodsSku().getCategoryPath().substring(
                                cartSkuVO.getGoodsSku().getCategoryPath().lastIndexOf(",") + 1
                        );
                        if (StringUtils.isNotEmpty(categoryId)) {
                            Double platFormCommission = CurrencyUtil.div(CurrencyUtil.mul(flowPrice, categoryService.findCategoryById(categoryId).getCommissionRate()), 100);
                            priceDetailDTO.setPlatFormCommission(platFormCommission);
                        }
                        priceDetailDTOS.add(priceDetailDTO);
                    }
                }
                cart.setPriceDetailDTO(PriceDetailDTO.accumulationPriceDTO(priceDetailDTOS));
            }
        }
    }

    private void buildTradePrice(TradeVO tradeVO) {
        List<PriceDetailDTO> priceDetailDTOS = new ArrayList<>();
        tradeVO.getCartList().parallelStream()
                .map(CartVO::getPriceDetailDTO)
                .forEach(priceDetailDTO -> priceDetailDTOS.add(priceDetailDTO));
        PriceDetailDTO priceDetailDTO = PriceDetailDTO.accumulationPriceDTO(priceDetailDTOS);
        tradeVO.setPriceDetailDTO(priceDetailDTO);
    }

    private void buildCart(TradeVO tradeVO) {
        List<CartVO> cartList = tradeVO.getCartList();
        for (CartVO cartVO : cartList) {
            List<CartSkuVO> skuList = cartVO.getSkuList();
            for (CartSkuVO cartSkuVO : skuList) {
                cartVO.addGoodsNum(cartSkuVO.getNum());
            }
        }
    }
}
