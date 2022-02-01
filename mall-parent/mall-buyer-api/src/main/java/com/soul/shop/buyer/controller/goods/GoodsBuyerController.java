package com.soul.shop.buyer.controller.goods;

import com.soul.shop.buyer.service.goods.GoodsSearchService;
import com.soul.shop.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "买家端，商品接口")
@RestController
@RequestMapping("/goods")
public class GoodsBuyerController {

  @Autowired
  private GoodsSearchService goodsSearchService;

  @ApiOperation(value = "获取搜索热词")
  @GetMapping("/hot-words")
  public Result<List<String>> getGoodsHotwords(Integer start, Integer end) {
    List<String> hotWords = goodsSearchService.getHotWords(start, end);
    return Result.success(hotWords);
  }
}
