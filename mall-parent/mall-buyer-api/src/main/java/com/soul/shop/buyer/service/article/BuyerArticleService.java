package com.soul.shop.buyer.service.article;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soul.shop.buyer.service.ArticleService;
import com.soul.shop.model.buyer.params.ArticleSearchParams;
import com.soul.shop.model.buyer.vo.article.ArticleCategoryVO;
import com.soul.shop.model.buyer.vo.article.ArticleVO;
import java.util.List;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class BuyerArticleService {

  @DubboReference(version = "1.0.0")
  private ArticleService articleService;


  /**
   * 文章列表
   * @param articleSearchParams
   * @return
   */
  public Page<ArticleVO> articlePage(ArticleSearchParams articleSearchParams) {
    return articleService.articlePage(articleSearchParams);
  }

  public ArticleVO customGet(Long id) {
    return articleService.findArticleVOById(id);
  }

  public List<ArticleCategoryVO> allChildren() {
    return articleService.findAllArticleCategory();
  }
}
