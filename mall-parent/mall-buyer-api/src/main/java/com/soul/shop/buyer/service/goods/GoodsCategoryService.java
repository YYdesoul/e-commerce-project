package com.soul.shop.buyer.service.goods;


import com.soul.shop.buyer.service.CategoryService;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.vo.CategoryVO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GoodsCategoryService {

  @DubboReference(version = "1.0.0")
  private CategoryService categoryService;

  /**
   * 1. 获取商品分类表 ms_category
   * 2. api 知识业务逻辑组合，具体的表查询应该交给dubbo服务
   * 3. 访问分类列表的请求如果很多，一个dubbo服务扛不住时，可以部署多个，api的代码不需要更改
   * 4. categoryService提供查询商品分类列表的服务
   * @param parentId
   * @return
   */
  public Result listAllChildren(Long parentId) {
    try { //  因为是远程调用所以要抛异常
      List<CategoryVO> list = categoryService.findCategoryTree(parentId);
      return Result.success(list);
    } catch (Exception e) {
      log.error("获取商品分类列表出错了：{}", e.getMessage());
    }

    return Result.fail();
  }
}
