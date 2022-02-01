package com.soul.shop.buyer.service;

import com.soul.shop.common.vo.Result;

public interface PageService {

  /**
   * 首页装修模板
   * @param clientType
   * @param pageType
   * @return
   */
  Result findPageTemplate(Integer clientType, int pageType);
}
