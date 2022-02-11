package com.soul.shop.model.buyer.vo.trade;

import com.soul.shop.model.buyer.dtos.trade.PriceDetailDTO;
import com.soul.shop.model.buyer.enums.CartTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车视图
 */
@Data
public class TradeVO implements Serializable {

    @ApiModelProperty(value = "sn")
    private String sn;

    @ApiModelProperty(value = "是否为其他订单下的订单，如果是则为依赖订单的sn，否则为空")
    private String parentOrderSn;

    @ApiModelProperty(value = "购物车列表")
    private List<CartVO> cartList;

    @ApiModelProperty(value = "整笔交易中所有的规格商品")
    private List<CartSkuVO> skuList;

    @ApiModelProperty(value = "购物车车计算后的总价")
    private PriceDetailDTO priceDetailDTO;

    /**
     * 购物车类型
     */
    private CartTypeEnum cartTypeEnum;


    /**
     * 客户端类型
     */
    private String clientType;

    /**
     * 买家名称
     */
    private String memberName;

    /**
     * 买家id
     */
    private String memberId;

    /**
     * 分销商id
     */
    private String distributionId;

    public void init(CartTypeEnum cartTypeEnum) {
        this.skuList = new ArrayList<>();
        this.cartList = new ArrayList<>();
        this.cartTypeEnum = cartTypeEnum;
        this.priceDetailDTO = new PriceDetailDTO();
    }
}

