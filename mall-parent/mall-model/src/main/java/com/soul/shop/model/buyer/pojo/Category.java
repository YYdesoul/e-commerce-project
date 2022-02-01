package com.soul.shop.model.buyer.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 商品分类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

  private Long id;

  private String name;

  private Long parentId;

  private Integer level;

  private Integer sortOrder;

  private Double commissionRate;

  private String image;

  private Boolean supportChannel;

  private Integer status;

  private Long createTime;

  private Long updateTime;
}