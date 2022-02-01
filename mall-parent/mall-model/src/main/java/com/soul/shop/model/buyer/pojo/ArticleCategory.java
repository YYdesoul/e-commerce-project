package com.soul.shop.model.buyer.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleCategory {

  private Long id;

  private Integer level;

  private Long parentId;

  private Integer sort;

  private String articleCategoryName;

  private String type;

  private Boolean deleteFlag;

  private Date createTime;

  private Date updateTime;
}