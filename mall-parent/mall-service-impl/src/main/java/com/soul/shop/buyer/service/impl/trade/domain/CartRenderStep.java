package com.soul.shop.buyer.service.impl.trade.domain;

import com.soul.shop.model.buyer.vo.trade.TradeVO;

public interface CartRenderStep {

    /**
     * 渲染一笔交易
     * 0-> 校验商品 1-》 满优惠渲染 2->渲染优惠 3->优惠券渲染 4->计算运费 5->计算价格 6->分销渲染 7->其他渲染
     *
     */
    void render(TradeVO tradeVO);
}
