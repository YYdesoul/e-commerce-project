package com.soul.shop.model.buyer.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParams implements Serializable {

  @ApiModelProperty(value = "页号")
  private Integer pageNumber = 1;

  @ApiModelProperty(value = "页面大小")
  private Integer pageSize = 10;

  @ApiModelProperty(value = "排序字段")
  private String sort;

  @ApiModelProperty(value = "排序方式 asc/desc")
  private String order;

  public boolean checkParams() {
    if (pageNumber == null || pageSize == null) {
      return false;
    }

    return true;
  }
}