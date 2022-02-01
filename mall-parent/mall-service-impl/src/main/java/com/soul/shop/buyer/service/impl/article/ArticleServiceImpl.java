package com.soul.shop.buyer.service.impl.article;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soul.shop.buyer.mapper.ArticleCategoryMapper;
import com.soul.shop.buyer.mapper.ArticleMapper;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.params.ArticleSearchParams;
import com.soul.shop.buyer.service.ArticleService;
import com.soul.shop.model.buyer.pojo.Article;
import com.soul.shop.model.buyer.pojo.ArticleCategory;
import com.soul.shop.model.buyer.vo.ArticleCategoryVO;
import com.soul.shop.model.buyer.vo.ArticleVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;

/**
 * 加 duoob注解， 发布当前的service服务到nacos上
 * ip:port/接口名称/方法名称
 * version便于接口有不同的实现，或者版本升级之用
 * interfaceClass 不加这个，事务无法使用
 */
@DubboService(version = "1.0.0", interfaceClass = ArticleService.class)
public class ArticleServiceImpl implements ArticleService {

  @Resource
  private ArticleMapper articleMapper;

  @Resource
  private ArticleCategoryMapper articleCategoryMapper;

  /**
   * 1. 查询条件有多个
   * 2. 查询条件进行判断，如果不为null 才进行条件查询
   * 3. 分页参数，分页查询
   * 4. 从Atcile 转换为ArticleVO, 表的字段并不是都用，用多少查多少
   * 5. copy copyList 做Article 转换为ArticleVo工作
   * @param articleSearchParams
   * @return
   */
  @Override
  public Page<ArticleVO> articlePage(ArticleSearchParams articleSearchParams) {
    if (!articleSearchParams.checkParams()) {
      return new Page<>();
    }
    Page<Article> articlePage = new Page<>(articleSearchParams.getPageNumber(),
        articleSearchParams.getPageSize());
    LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
    if (StringUtils.isNotBlank(articleSearchParams.getCategoryId())) {
      queryWrapper.eq(Article::getCategoryId, articleSearchParams.getCategoryId());
    }
    if (StringUtils.isNotBlank(articleSearchParams.getTitle())) {
      queryWrapper.likeRight(Article::getTitle, articleSearchParams.getTitle());
    }
    if (StringUtils.isNotBlank(articleSearchParams.getType())) {
      queryWrapper.eq(Article::getType, articleSearchParams.getType());
    }
    queryWrapper.select(Article::getCategoryId, Article::getId, Article::getTitle, Article::getType);
    Page<Article> articlePage1 = articleMapper.selectPage(articlePage, queryWrapper);
    Page<ArticleVO> articleVOPage = new Page<>();
    BeanUtils.copyProperties(articlePage1, articleVOPage);
    List<Article> records = articlePage1.getRecords();
    List<ArticleVO> articleVOList = copyList(records);
    articleVOPage.setRecords(articleVOList);
    return articleVOPage;
  }

  @Override
  public ArticleVO findArticleVOById(Long id) {
    Article article = articleMapper.selectById(id);
    ArticleVO articleVO = copy(article);
    return articleVO;
  }

  /**
   * 1. 查找所有的文章分类信息，为了速度
   * 2. 代码组树形结构（递归）
   * @return
   */
  @Override
  public List<ArticleCategoryVO> findAllArticleCategory() {
    LambdaQueryWrapper<ArticleCategory> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(ArticleCategory::getDeleteFlag, false);

    List<ArticleCategory> articleCategorieList = articleCategoryMapper.selectList(queryWrapper);
    List<ArticleCategoryVO> articleCategoryVOList = copyCategoryList(articleCategorieList);

    List<ArticleCategoryVO> articleCategoryVOS = new ArrayList<>();

    for (ArticleCategoryVO articleCategoryVO : articleCategoryVOList) {
      if (articleCategoryVO.getParentId().equals("0")) {
        articleCategoryVOS.add(articleCategoryVO);
        addCategoryChild(articleCategoryVO, articleCategoryVOList);
      }
    }
    return articleCategoryVOS;
  }

  private void addCategoryChild(ArticleCategoryVO articleCategoryVO,
      List<ArticleCategoryVO> articleCategoryVOList) {
    List<ArticleCategoryVO> categoryVOList = new ArrayList<>();

    for (ArticleCategoryVO categoryVO : articleCategoryVOList) {
      if (articleCategoryVO.getId().equals(categoryVO.getParentId())) {
        categoryVOList.add(categoryVO);
        addCategoryChild(categoryVO, articleCategoryVOList);
      }
    }
    articleCategoryVO.setChildren(categoryVOList);
  }

  private List<ArticleCategoryVO> copyCategoryList(List<ArticleCategory> articleCategorieList) {
    List<ArticleCategoryVO> articleCategoryVOList = new ArrayList<>();
    articleCategorieList.forEach(
        articleCategory -> articleCategoryVOList.add(copy(articleCategory))
    );
    return articleCategoryVOList;
  }

  private List<ArticleVO> copyList(List<Article> articleList) {
    List<ArticleVO> articleVOList = new ArrayList<>();
    articleList.forEach(
        article -> articleVOList.add(copy(article))
    );
    return articleVOList;
  }

  private ArticleVO copy(Article article) {
    if (article == null) {
      return null;
    }
    ArticleVO articleVO = new ArticleVO();
    BeanUtils.copyProperties(article, articleVO);
    articleVO.setId(article.getId().toString());
    return articleVO;
  }

  public ArticleCategoryVO copy(ArticleCategory articleCategory) {
    if (articleCategory == null) {
      return null;
    }

    ArticleCategoryVO articleCategoryVO = new ArticleCategoryVO();

    BeanUtils.copyProperties(articleCategory, articleCategoryVO);
    articleCategoryVO.setId(articleCategory.getId().toString());
    articleCategoryVO.setParentId(articleCategory.getParentId().toString());
    return articleCategoryVO;
  }
}
