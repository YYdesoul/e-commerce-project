package com.soul.shop.model.buyer.pojo.goods;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 商品
 */
@Data
public class Goods  {

    private Long id;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品编号
     */
    private String sn;
    /**
     * 品牌id
     */
    private String brandId;

    private String categoryPath;

    //计量单位
    private String goodsUnit;

    /**
     * 卖点
     */
    private String sellingPoint;

    /**
     * 重量
     */
    private Double weight;
    /**
     * 上架状态
     *
     * @see com.mszlu.shop.model.buyer.eums.goods.GoodsStatusEnum
     */
    private Integer marketEnable;
    /**
     * 详情
     */
    private String intro;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 成本价格
     */
    private BigDecimal cost;

    /**
     * 购买数量
     */
    private Integer buyCount;
    /**
     * 库存
     */
    private Integer quantity;
    /**
     * 商品好评率
     */
    private Double grade;
    /**
     * 缩略图路径
     */
    private String thumbnail;
    /**
     * 小图路径
     */
    private String small;
    /**
     * 原图路径
     */
    private String original;
    /**
     * 店铺分类id
     */
    private String storeCategoryPath;
    /**
     * 评论数量
     */
    private Integer commentNum;
    /**
     * 卖家id
     */
    private String storeId;
    /**
     * 卖家名字
     */
    private String storeName;
    /**
     * 运费模板id
     */
    private String templateId;
    /**
     * 审核状态
     *
     * @see com.mszlu.shop.model.buyer.eums.goods.GoodsAuthEnum
     */
    private Integer isAuth;
    /**
     * 审核信息
     */
    private String authMessage;
    /**
     * 下架原因
     */
    private String underMessage;
    /**
     * 是否自营
     */
    private Boolean selfOperated;
    /**
     * 商品移动端详情
     */
    private String mobileIntro;
    /**
     * 商品视频
     */
    private String goodsVideo;


    private boolean recommend;

    private String salesModel;


    /**
     * @see com.mszlu.shop.model.buyer.eums.goods.GoodsTypeEnum
     */
    private Integer goodsType;

}
