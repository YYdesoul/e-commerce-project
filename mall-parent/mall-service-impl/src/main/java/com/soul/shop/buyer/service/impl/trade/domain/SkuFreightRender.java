package com.soul.shop.buyer.service.impl.trade.domain;

import com.soul.shop.buyer.service.impl.trade.domain.CartRenderStep;
import com.soul.shop.model.buyer.vo.trade.TradeVO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;


/**
 * sku 运费计算
 */
@Order(4)
@Service
public class SkuFreightRender implements CartRenderStep {


    @Override
    public void render(TradeVO tradeVo) {

    }
}