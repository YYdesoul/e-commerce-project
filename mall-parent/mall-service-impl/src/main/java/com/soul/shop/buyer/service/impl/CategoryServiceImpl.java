package com.soul.shop.buyer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.soul.shop.buyer.mapper.CategoryMapper;
import com.soul.shop.buyer.service.CategoryService;
import com.soul.shop.model.buyer.pojo.Category;
import com.soul.shop.model.buyer.vo.CategoryVO;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

@DubboService(version = "1.0.0", interfaceClass = CategoryService.class)
//@Transactional
public class CategoryServiceImpl implements CategoryService {

  @Resource
  private CategoryMapper categoryMapper;

  /**
   * 1. 根据parentId 获取对应的分类列表
   * 2. 获取到的分类列表 只有1级
   * 3. 根据sql 发现问题：循环递归的获取所有分类的子分类列表，如果这么做，数据库就会多次连接，性能会降低
   * 4. 所以把所有的分类查出来，然后在代码中完成逻辑，这样效率高
   * @param parentId
   * @return
   */
  @Override
  public List<CategoryVO> findCategoryTree(Long parentId) {
    return categoryTree(parentId);
  }

  @Override
  public List<String> getCategoryNameByIds(List<String> idList) {
    LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.in(Category::getId, idList);
    List<Category> categories = categoryMapper.selectList(queryWrapper);
    List<String> strings = categories.stream().map(Category::getName).collect(Collectors.toList());
    return strings;
  }

  private List<CategoryVO> categoryTree(Long parentId) {
    LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(Category::getStatus, 0);
    List<Category> categories = categoryMapper.selectList(queryWrapper);
    List<CategoryVO> categoryVOS = copyList(categories);
    List<CategoryVO> categoryVOList = new ArrayList<>();

    for (CategoryVO categoryVO: categoryVOS) {
      if (categoryVO.getParentId().equals(parentId)) {
        categoryVOList.add(categoryVO);
        this.addAllchildren(categoryVO, categoryVOS);
      }
    }

    return categoryVOList;
  }

  private void addAllchildren(CategoryVO categoryVO, List<CategoryVO> categoryVOS) {
    ArrayList<CategoryVO> categoryVOList = new ArrayList<>();
    for (CategoryVO vo: categoryVOS) {
      if (vo.getParentId().equals(categoryVO.getId())) {
        categoryVOList.add(vo);
        addAllchildren(vo, categoryVOS);
      }
    }
    categoryVO.setChildren(categoryVOList);
  }

  public CategoryVO copy(Category category) {
    CategoryVO target = new CategoryVO();
    BeanUtils.copyProperties(category, target);
    return target;
  }

  public List<CategoryVO> copyList(List<Category> categoryList) {
    List<CategoryVO> categoryVOList = new ArrayList<>();
    categoryList.forEach(
        category -> categoryVOList.add(copy(category))
    );
    return categoryVOList;
  }


}
