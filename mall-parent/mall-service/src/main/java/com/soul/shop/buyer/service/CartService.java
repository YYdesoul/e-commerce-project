package com.soul.shop.buyer.service;

import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.enums.CartTypeEnum;
import com.soul.shop.model.buyer.vo.trade.TradeVO;

public interface CartService {
    Result<Object> addCart(CartTypeEnum cartTypeEnum, String skuId, Integer num, String userId);

    Result<TradeVO> buildAllTrade(CartTypeEnum cartTypeEnum, String userId);

    Result<Integer> countGoodsInTrade(CartTypeEnum cart, String id);
}
