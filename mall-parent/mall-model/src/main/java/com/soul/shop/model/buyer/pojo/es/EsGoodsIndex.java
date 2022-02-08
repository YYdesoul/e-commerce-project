package com.soul.shop.model.buyer.pojo.es;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * es商品索引
 **/
@Data
@Document(indexName = "es_goods")
@ToString
@NoArgsConstructor
public class EsGoodsIndex implements Serializable {

    @Id
    private String id;

    /**
     * 商品id
     */
    @Field(type = FieldType.Text)
    private String goodsId;

    /**
     * 商品名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String goodsName;

    /**
     * 商品编号
     */
    @Field(type = FieldType.Keyword)
    private String sn;

    /**
     * 卖家id
     */
    @Field(type = FieldType.Text)
    private String storeId;

    /**
     * 卖家名称
     */
    @Field(type = FieldType.Text)
    private String storeName;

    /**
     * 销量
     */
    @Field(type = FieldType.Integer)
    private Integer buyCount;

    /**
     * 小图
     */
    private String small;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 品牌id
     */
    @Field(type = FieldType.Integer, fielddata = true)
    private String brandId;

    /**
     * 分类path
     */
    @Field(type = FieldType.Keyword, fielddata = true)
    private String categoryPath;

    /**
     * 店铺分类id
     */
    @Field(type = FieldType.Keyword)
    private String storeCategoryPath;

    /**
     * 商品价格
     */
    @Field(type = FieldType.Double)
    private Double price;

    /**
     * 促销价
     */
    @Field(type = FieldType.Double)
    private Double promotionPrice;

    /**
     * 如果是积分商品需要使用的积分
     */
    @Field(type = FieldType.Integer)
    private Integer point;

    /**
     * 评价数量
     */
    @Field(type = FieldType.Integer)
    private Integer commentNum;

    /**
     * 好评数量
     */
    @Field(type = FieldType.Integer)
    private Integer highPraiseNum;

    /**
     * 好评率
     */
    @Field(type = FieldType.Double)
    private Double grade;

    /**
     * 详情
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String intro;

    /**
     * 商品移动端详情
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String mobileIntro;

    /**
     * 是否自营
     */
    @Field(type = FieldType.Boolean)
    private Boolean selfOperated;

    /**
     * 是否为推荐商品
     */
    @Field(type = FieldType.Boolean)
    private Boolean recommend;

    /**
     * 销售模式
     */
    @Field(type = FieldType.Text)
    private String salesModel;

    /**
     * 审核状态
     */
    @Field(type = FieldType.Integer)
    private Integer isAuth;

    /**
     * 卖点
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String sellingPoint;

    /**
     * 上架状态
     */
    @Field(type = FieldType.Integer)
    private Integer marketEnable;

    /**
     * 商品视频
     */
    @Field(type = FieldType.Text)
    private String goodsVideo;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date releaseTime;

    /**
     * 商品类型 详情GoodsTypeEnum
     */
    private Integer goodsType;

    /**
     * 商品属性（参数和规格）
     */
    @Field(type = FieldType.Nested)
    private List<EsGoodsAttribute> attrList;

    /**
     * 商品促销活动集合
     * key 为 促销活动类型
     *
     * @see PromotionTypeEnum
     * value 为 促销活动实体信息
     */
    @Field(type = FieldType.Nested)
    private Map<String, Object> promotionMap;

}













