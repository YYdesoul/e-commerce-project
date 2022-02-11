package com.soul.shop.buyer.service.impl.trade.domain;

import com.soul.shop.model.buyer.vo.trade.TradeVO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * sn 生成
 */
@Order(7)
@Service
public class CartSnRender implements CartRenderStep {

    @Override
    public void render(TradeVO tradeVo) {

    }
}
