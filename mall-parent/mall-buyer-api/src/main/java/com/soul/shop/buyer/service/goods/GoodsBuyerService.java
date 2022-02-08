package com.soul.shop.buyer.service.goods;

import com.soul.shop.buyer.service.GoodsSkuService;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.vo.goods.GoodsDetailVO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GoodsBuyerService {

    @DubboReference(version = "1.0.0")
    private GoodsSkuService goodsSkuService;

    public Result<GoodsDetailVO> getGoodsSkuDetail(String goodsId, String skuId) {
        return goodsSkuService.getGoodsSkuDetail(goodsId, skuId);
    }
}
