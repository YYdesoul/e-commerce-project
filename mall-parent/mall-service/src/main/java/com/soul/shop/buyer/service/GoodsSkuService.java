package com.soul.shop.buyer.service;

import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.pojo.goods.GoodsSku;
import com.soul.shop.model.buyer.vo.goods.GoodsDetailVO;

import java.util.Map;

public interface GoodsSkuService {

    void importES();

    Result<GoodsDetailVO> getGoodsSkuDetail(String goodsId, String skuId);

    GoodsSku findGoodsSkuById(String skuId);
}
