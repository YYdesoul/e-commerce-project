package com.soul.shop.model.buyer.vo.goods;

import com.soul.shop.model.buyer.pojo.es.EsGoodsIndex;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GoodsPageVO implements Serializable {


    private Long totalElements;

    private List<EsGoodsIndex> content;
}
