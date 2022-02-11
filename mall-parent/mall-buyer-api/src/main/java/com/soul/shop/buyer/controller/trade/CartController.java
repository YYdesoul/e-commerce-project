package com.soul.shop.buyer.controller.trade;

import com.soul.shop.buyer.service.trade.BuyerCartService;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.vo.trade.TradeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api (tags = "买家端，购物车接口")
@RequestMapping("/trade/carts")
public class CartController {

    /**
     * 购物车
     */
    @Autowired
    private BuyerCartService buyerCartService;

    @ApiOperation("向购物车中添加一个产品")
    @PostMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "skuId", value = "产品ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "num", value = "此产品的购买数量", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "cartType", value = "购物车类型，默认加入购物车", paramType = "query")
    })
    public Result<Object> add(String skuId, Integer num, String cartType) {
        // 读取选中的列表
        return buyerCartService.add(skuId, num, cartType);
    }

    @ApiOperation("获取购物车详情")
    @GetMapping("/all")
    public Result<TradeVO> cartAll() {
        return this.buyerCartService.getAllTrade();
    }
}
