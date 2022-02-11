package com.soul.shop.buyer.service.impl.trade.domain;

import com.soul.shop.model.buyer.vo.trade.TradeVO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;


/**
 * FullDiscountRender 
 */
@Service
@Order(1)
public class FullDiscountRender implements CartRenderStep {


    @Override
    public void render(TradeVO tradeVo) {

    }
}
