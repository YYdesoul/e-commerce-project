package com.soul.shop.model.buyer.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleSearchParams extends PageParams implements Serializable {

  @ApiModelProperty(value = "分类ID")
  private String categoryId;

  @ApiModelProperty(value = "标题")
  private String title;

  @ApiModelProperty(value = "分类类型")
  private String type;

}
