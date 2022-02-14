package com.soul.shop.buyer.service.trade;

import com.soul.shop.buyer.handler.security.UserContext;
import com.soul.shop.buyer.service.CartService;
import com.soul.shop.common.security.AuthUser;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.enums.CartTypeEnum;
import com.soul.shop.model.buyer.vo.trade.TradeVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BuyerCartService {

    @DubboReference(version = "1.0.0")
    private CartService cartService;

    /**
     * 1. 判断cartYpe 有没有，如果没有默认为购物车类型
     * 2. 获取当前的登录永不 得到用户id
     * 3. 调用dubbo服务，购物车服务，提供添加购物车的功能
     * @param skuId
     * @param num
     * @param cartType
     * @return
     */
    public Result<Object> add(String skuId, Integer num, String cartType) {
        // 获取购物车类型，默认为购物车
        CartTypeEnum cartTypeEnum = getCartType(cartType);
        AuthUser currentUser = UserContext.getCurrentUser();
        String id = currentUser.getId();
        return cartService.addCart(cartTypeEnum, skuId, num, id);
    }

    private CartTypeEnum getCartType(String cartType) {
        if (StringUtils.isBlank(cartType)) {
            return CartTypeEnum.CART;
        }

        try {
            return CartTypeEnum.valueOf(cartType);
        } catch (Exception e) {
            log.error("no cart Type matched");
            return CartTypeEnum.CART;
        }
    }

    public Result<TradeVO> getAllTrade() {
        // 未登录的用户是不能将商品加入购物车的，也就无法查看购物车详情
        AuthUser currentUser = UserContext.getCurrentUser();
        CartTypeEnum cart = CartTypeEnum.CART;
        return cartService.buildAllTrade(cart, currentUser.getId());
    }

    public Result<Integer> countGoodsInTrade() {
        // 未登录的用户是不能将商品加入购物车的，也就无法查看购物车详情
        AuthUser currentUser = UserContext.getCurrentUser();
        CartTypeEnum cart = CartTypeEnum.CART;
        return cartService.countGoodsInTrade(cart, currentUser.getId());
    }
}
