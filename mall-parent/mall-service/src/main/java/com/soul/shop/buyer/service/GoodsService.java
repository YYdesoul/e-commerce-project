package com.soul.shop.buyer.service;

import com.soul.shop.model.buyer.params.EsGoodsSearchParam;
import com.soul.shop.model.buyer.params.PageParams;
import com.soul.shop.model.buyer.vo.goods.GoodsPageVO;

public interface GoodsService {
    GoodsPageVO searchGoods(EsGoodsSearchParam goodsSearchParams, PageParams pageParams);
}
