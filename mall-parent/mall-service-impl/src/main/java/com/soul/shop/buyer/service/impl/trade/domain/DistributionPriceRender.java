package com.soul.shop.buyer.service.impl.trade.domain;

import com.soul.shop.buyer.service.impl.trade.domain.CartRenderStep;
import com.soul.shop.model.buyer.vo.trade.TradeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 购物促销信息渲染实现
 */
@Service
@Order(6)
public class DistributionPriceRender implements CartRenderStep {

    @Override
    public void render(TradeVO tradeVo) {

    }
}
