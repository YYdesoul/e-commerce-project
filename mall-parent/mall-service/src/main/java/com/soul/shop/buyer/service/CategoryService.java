package com.soul.shop.buyer.service;

import com.soul.shop.model.buyer.pojo.Category;
import com.soul.shop.model.buyer.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    /**
     * 根据父i获取对应的商品分类列表
     *
     * @param parentId
     * @return
     */
    List<CategoryVO> findCategoryTree(Long parentId);

    List<String> getCategoryNameByIds(List<String> asList);

    Category findCategoryById(String categoryId);
}
