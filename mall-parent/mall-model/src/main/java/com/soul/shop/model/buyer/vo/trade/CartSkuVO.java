package com.soul.shop.model.buyer.vo.trade;

import com.soul.shop.model.buyer.dtos.trade.PriceDetailDTO;
import com.soul.shop.model.buyer.enums.CartTypeEnum;
import com.soul.shop.model.buyer.pojo.goods.GoodsSku;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 购物车中的产品
 *
 */
@Data
@NoArgsConstructor
public class CartSkuVO  implements Serializable {


    private String sn;
    /**
     * 对应的sku DO
     */
    private GoodsSku goodsSku;

    @ApiModelProperty(value = "购买数量")
    private Integer num;

    @ApiModelProperty(value = "购买时的成交价")
    private Double purchasePrice;

    @ApiModelProperty(value = "小记")
    private Double subTotal;
    /**
     * 是否选中，要去结算 0:未选中 1:已选中，默认
     */
    @ApiModelProperty(value = "是否选中，要去结算")
    private Boolean checked;

    @ApiModelProperty(value = "是否免运费")
    private Boolean isFreeFreight;

    @ApiModelProperty(value = "积分购买 积分数量")
    private Integer point;

    @ApiModelProperty(value = "是否失效 ")
    private Boolean invalid;

    @ApiModelProperty(value = "购物车商品错误消息")
    private String errorMessage;

    @ApiModelProperty(value = "是否可配送")
    private Boolean isShip;

    /**
     * @see com.soul.shop.model.buyer.enums.CartTypeEnum
     */
    @ApiModelProperty(value = "购物车类型")
    private CartTypeEnum cartType;

    @ApiModelProperty(value = "卖家id")
    private String storeId;

    @ApiModelProperty(value = "卖家姓名")
    private String storeName;

    @ApiModelProperty(value = "此商品价格展示")
    private PriceDetailDTO priceDetailDTO;

    public CartSkuVO(GoodsSku goodsSku) {
        this.goodsSku = goodsSku;
        this.checked = true;
        this.invalid = false;
        this.errorMessage = "";
        this.isShip = true;
        this.purchasePrice = goodsSku.getIsPromotion() != null && goodsSku.getIsPromotion() ? goodsSku.getPromotionPrice().doubleValue() : goodsSku.getPrice().doubleValue();
        this.isFreeFreight = false;
        this.setStoreId(goodsSku.getStoreId());
        this.setStoreName(goodsSku.getStoreName());
        // 初始化
        this.priceDetailDTO = new PriceDetailDTO();
        this.priceDetailDTO.addGoodsPrice(goodsSku.getPrice().doubleValue());
    }
}