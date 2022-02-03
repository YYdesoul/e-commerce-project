package com.soul.shop.buyer.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soul.shop.model.buyer.params.ArticleSearchParams;
import com.soul.shop.model.buyer.vo.article.ArticleCategoryVO;
import com.soul.shop.model.buyer.vo.article.ArticleVO;
import java.util.List;

public interface ArticleService {

  /**
   * 根据查询条件，获取文章的分页信息
   * @param articleSearchParams
   * @return
   */
  Page<ArticleVO> articlePage(ArticleSearchParams articleSearchParams);

  /**
   * 根据id获取文章详情
   * @param id
   * @return
   */
  ArticleVO findArticleVOById(Long id);

  /**
   * 文章分类列表
   * @return
   */
  List<ArticleCategoryVO> findAllArticleCategory();
}
