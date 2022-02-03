package com.soul.shop.model.buyer.vo.article;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleCategoryVO implements Serializable {

  private String id;

  private Integer level;

  private String parentId;

  private Integer sort;

  private String articleCategoryName;

  private String type;

  @ApiModelProperty("子菜单")
  private List<ArticleCategoryVO> children = new ArrayList<>();

  public List<ArticleCategoryVO> getChidren() {
    if (children != null) {
      children.sort(
          (o1, o2) -> o1.getSort().compareTo(o2.getSort())
      );
      return children;
    }
    return null;
  }
}
