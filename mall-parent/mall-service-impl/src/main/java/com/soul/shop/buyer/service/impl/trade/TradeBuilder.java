package com.soul.shop.buyer.service.impl.trade;

import com.soul.shop.buyer.service.impl.trade.domain.CartRenderStep;
import com.soul.shop.model.buyer.vo.trade.TradeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TradeBuilder {

    // 购物车渲染步骤
    @Autowired
    private List<CartRenderStep> cartRenderSteps;

    /**
     * 购物车购物车渲染
     * 0-> 校验商品， 1-》 满优惠渲染， 2->渲染优惠，  5->计算价格
     */
//    int[] cartRender = {0, 1, 2, 5};
    /**
     * 购物车购物车渲染
     * 0-> 校验商品  5->计算价格
     */
    int [] cartRender = {0, 5};

    /**
     * 构造购物车
     * 购物车与结算信息不一致的地方主要是优惠券计算和运费计算，其他规则都是一致都
     *
     * @return 购物车展示信息
     */
    public TradeVO buildCart(TradeVO tradeVO) {
        // 按照计划进行渲染
        for (int index : cartRender) {
            try {
                cartRenderSteps.get(index).render(tradeVO);
                log.info("finish buildCard");
            } catch (Exception e) {
                log.error("购物车{}渲染异常: ", cartRenderSteps.get(index), e);
            }
        }
        return tradeVO;
    }
}
