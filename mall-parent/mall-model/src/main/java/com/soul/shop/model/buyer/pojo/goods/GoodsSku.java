package com.soul.shop.model.buyer.pojo.goods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品sku
 */
@Data
public class GoodsSku implements Serializable {

    private Long id;

    @ApiModelProperty(value = "商品id")
    private String goodsId;

    @ApiModelProperty(value = "规格信息json", hidden = true)
    @JsonIgnore
    private String specs;

    @ApiModelProperty(value = "规格信息")
    private String simpleSpecs;

    @ApiModelProperty(value = "配送模版id")
    private String freightTemplateId;

    @ApiModelProperty(value = "是否是促销商品")
    private Boolean isPromotion;

    @ApiModelProperty(value = "促销价")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品编号")
    private String sn;

    @ApiModelProperty(value = "品牌id")
    private String brandId;

    @ApiModelProperty(value = "分类path")
    private String categoryPath;

    @ApiModelProperty(value = "计量单位")
    private String goodsUnit;

    @ApiModelProperty(value = "卖点")
    private String sellingPoint;

    @ApiModelProperty(value = "重量")
    private Double weight;
    /**
     * @see com.soul.shop.model.buyer.enums.goods.GoodsStatusEnum
     */
    @ApiModelProperty(value = "上架状态")
    private Integer marketEnable;

    @ApiModelProperty(value = "商品详情")
    private String intro;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "成本价格")
    private BigDecimal cost;

    @ApiModelProperty(value = "浏览数量")
    private Integer viewCount;

    @ApiModelProperty(value = "购买数量")
    private Integer buyCount;

    @ApiModelProperty(value = "库存")
    private Integer quantity;

    @ApiModelProperty(value = "商品好评率")
    private Double grade;

    @ApiModelProperty(value = "缩略图路径")
    private String thumbnail;

    @ApiModelProperty(value = "大图路径")
    private String big;

    @ApiModelProperty(value = "小图路径")
    private String small;

    @ApiModelProperty(value = "原图路径")
    private String original;

    @ApiModelProperty(value = "店铺分类id")
    private String storeCategoryPath;

    @ApiModelProperty(value = "评论数量")
    private Integer commentNum;

    @ApiModelProperty(value = "卖家id")
    private String storeId;

    @ApiModelProperty(value = "卖家名字")
    private String storeName;

    @ApiModelProperty(value = "运费模板id")
    private String templateId;

    /**
     * @see com.soul.shop.model.buyer.enums.goods.GoodsAuthEnum
     */
    @ApiModelProperty(value = "审核状态")
    private Integer isAuth;

    @ApiModelProperty(value = "审核信息")
    private String authMessage;

    @ApiModelProperty(value = "下架原因")
    private String underMessage;

    @ApiModelProperty(value = "是否自营")
    private Boolean selfOperated;

    @ApiModelProperty(value = "商品移动端详情")
    private String mobileIntro;

    @ApiModelProperty(value = "商品视频")
    private String goodsVideo;

    @ApiModelProperty(value = "是否为推荐商品", required = true)
    private boolean recommend;

    @ApiModelProperty(value = "销售模式", required = true)
    private String salesModel;
    /**
     * @see com.soul.shop.model.buyer.enums.goods.GoodsTypeEnum
     */
    @ApiModelProperty(value = "商品类型", required = true)
    private Integer goodsType;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    public Double getWeight() {
        if (weight == null) {
            return 0d;
        }
        return weight;
    }

}
