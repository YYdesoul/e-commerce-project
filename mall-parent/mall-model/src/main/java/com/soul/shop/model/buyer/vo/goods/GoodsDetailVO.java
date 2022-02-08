package com.soul.shop.model.buyer.vo.goods;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class GoodsDetailVO implements Serializable {

    //商品sku数据
    private GoodsSkuVO data;

    //商品类别名称列表
    private List<String> categoryName;

    //规格信息
    private List<GoodsSkuSpecVO> specs;
    //促销信息
    private Map<String, Object> promotionMap;
}