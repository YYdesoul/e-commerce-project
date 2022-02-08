package com.soul.shop.buyer.controller.goods;

import com.soul.shop.buyer.service.goods.GoodsBuyerService;
import com.soul.shop.buyer.service.goods.GoodsSearchService;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.params.EsGoodsSearchParam;
import com.soul.shop.model.buyer.params.PageParams;
import com.soul.shop.model.buyer.vo.goods.GoodsDetailVO;
import com.soul.shop.model.buyer.vo.goods.GoodsPageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "买家端，商品接口")
@RestController
@RequestMapping("/goods")
public class GoodsBuyerController {

  @Autowired
  private GoodsSearchService goodsSearchService;

  @Autowired
  private GoodsBuyerService goodsBuyerService;

  @ApiOperation(value = "获取搜索热词")
  @GetMapping("/hot-words")
  public Result<List<String>> getGoodsHotwords(Integer start, Integer end) {
    List<String> hotWords = goodsSearchService.getHotWords(start, end);
    return Result.success(hotWords);
  }

  @ApiOperation(value = "从ES中获取商品信息")
  @GetMapping("/es")
  public Result<GoodsPageVO> getGoodsByPageFromEs(EsGoodsSearchParam goodsSearchParams, PageParams pageParams) {
    GoodsPageVO goodsPageVO = goodsSearchService.searchGoods(goodsSearchParams, pageParams);
    return Result.success(goodsPageVO);
  }

  @GetMapping("/sku/{goodsId}/{skuId}")
  public Result<GoodsDetailVO> getSku (@PathVariable("goodsId") String goodsId,
                                       @PathVariable("skuId") String skuId) {
    // 读取选中的列表
    return goodsBuyerService.getGoodsSkuDetail(goodsId, skuId);
  }
}
