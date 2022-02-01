package com.soul.shop.model.buyer.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageTemplate {

  private Long id;

  private String name;

  private Integer clientType;

  private Integer pageType;

  private Integer openStatus;

  private Integer status;

  private Long createTime;

  private Long updateTime;
}
