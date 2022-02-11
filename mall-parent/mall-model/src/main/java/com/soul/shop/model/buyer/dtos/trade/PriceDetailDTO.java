package com.soul.shop.model.buyer.dtos.trade;

import com.soul.shop.common.utils.CurrencyUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品流水
 */
@Data
public class PriceDetailDTO implements Serializable {


    @ApiModelProperty(value = "商品总金额（商品原价）")
    private Double goodsPrice;
    @ApiModelProperty(value = "优惠金额")
    private Double discountPrice;
    @ApiModelProperty(value = "优惠券金额")
    private Double couponPrice;
    @ApiModelProperty(value = "配送费")
    private Double freightPrice;
    @ApiModelProperty(value = "订单修改金额")
    private Double updatePrice;

    @ApiModelProperty(value = "单品分销返现支出")
    private Double distributionCommission;

    @ApiModelProperty(value = "平台收取交易佣金")
    private Double platFormCommission;

    @ApiModelProperty(value = "平台优惠券 使用金额")
    private Double siteCouponPrice;

    @ApiModelProperty(value = "站点优惠券佣金比例")
    private Double siteCouponPoint;

    @ApiModelProperty(value = "站点优惠券佣金")
    private Double siteCouponCommission;


    @ApiModelProperty(value = "流水金额(入账 出帐金额) = goodsPrice + freight - discountPrice - couponPrice + updatePrice")
    private Double flowPrice;

    @ApiModelProperty(value = "最终结算金额 = flowPrice - platFormCommission - distributionCommission")
    private Double billPrice;


    public PriceDetailDTO() {
        goodsPrice = 0d;
        freightPrice = 0d;

        discountPrice = 0d;
        couponPrice = 0d;

        distributionCommission = 0d;
        platFormCommission = 0d;

        updatePrice = 0d;

        flowPrice = 0d;
        billPrice = 0d;

        siteCouponPrice = 0d;
        siteCouponPoint = 0d;
        siteCouponCommission = 0d;

    }

    public static PriceDetailDTO accumulationPriceDTO(List<PriceDetailDTO> priceDetailDTOS) {

        PriceDetailDTO priceDetailDTO = new PriceDetailDTO();

        for (PriceDetailDTO priceDetail : priceDetailDTOS) {
            priceDetailDTO.addGoodsPrice(priceDetail.getGoodsPrice());
            priceDetailDTO.addFreightPrice(priceDetail.getFreightPrice());
            priceDetailDTO.addUpdatePrice(priceDetail.getUpdatePrice());
            priceDetailDTO.addDistributionCommission(priceDetail.getDistributionCommission());
            priceDetailDTO.addDiscountPrice(priceDetail.getDiscountPrice());
            priceDetailDTO.addPlatFormCommission(priceDetail.getPlatFormCommission());
            priceDetailDTO.addSiteCouponPrice(priceDetail.getSiteCouponPrice());
            priceDetailDTO.addSiteCouponPoint(priceDetail.getSiteCouponPoint());
            priceDetailDTO.addSiteCouponCommission(priceDetail.getSiteCouponCommission());
            priceDetailDTO.addFlowPrice(priceDetail.getFlowPrice());
            priceDetailDTO.addBillPrice(priceDetail.getBillPrice());
        }
        return priceDetailDTO;
    }

    public void addGoodsPrice(Double goodsPrice) {
        this.goodsPrice = CurrencyUtil.add(this.goodsPrice,goodsPrice);
    }
    public void addFreightPrice(Double freightPrice) {
        this.freightPrice = CurrencyUtil.add(this.freightPrice,freightPrice);
    }

    public void addDiscountPrice(Double discountPrice) {
        this.discountPrice = CurrencyUtil.add(this.discountPrice,discountPrice);
    }
    public void addUpdatePrice(Double updatePrice) {
        this.updatePrice = CurrencyUtil.add(this.updatePrice,updatePrice);
    }
    public void addDistributionCommission(Double distributionCommission) {
        this.distributionCommission = CurrencyUtil.add(this.distributionCommission,distributionCommission);
    }
    public void addPlatFormCommission(Double platFormCommission) {
        this.platFormCommission = CurrencyUtil.add(this.platFormCommission,platFormCommission);
    }
    public void addSiteCouponPrice(Double siteCouponPrice) {
        this.siteCouponPrice = CurrencyUtil.add(this.siteCouponPrice,siteCouponPrice);
    }
    public void addSiteCouponPoint(Double siteCouponPoint) {
        this.siteCouponPoint = CurrencyUtil.add(this.siteCouponPoint,siteCouponPoint);
    }
    public void addSiteCouponCommission(Double siteCouponCommission) {
        this.siteCouponCommission = CurrencyUtil.add(this.siteCouponCommission,siteCouponCommission);
    }
    public void addFlowPrice(Double flowPrice) {
        this.flowPrice = CurrencyUtil.add(this.flowPrice,flowPrice);
    }
    public void addBillPrice(Double billPrice) {
        this.billPrice = CurrencyUtil.add(this.billPrice,billPrice);
    }
}
