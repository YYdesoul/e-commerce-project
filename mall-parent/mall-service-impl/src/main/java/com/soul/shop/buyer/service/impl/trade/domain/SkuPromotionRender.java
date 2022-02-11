package com.soul.shop.buyer.service.impl.trade.domain;

import com.soul.shop.model.buyer.vo.trade.TradeVO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 购物促销信息渲染实现
 */
@Service
@Order(2)
public class SkuPromotionRender implements CartRenderStep {
    @Override
    public void render(TradeVO tradeVo) {

    }
}
