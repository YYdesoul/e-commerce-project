package com.soul.shop.model.buyer.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TemplateDetail {

  private Long id;

  private Long templateId;

  private String templateType;

  private String templateData;

  private Integer status;

  private Long createTime;
}
