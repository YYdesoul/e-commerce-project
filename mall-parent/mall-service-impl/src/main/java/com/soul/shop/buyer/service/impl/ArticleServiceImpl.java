package com.soul.shop.buyer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soul.shop.buyer.mapper.TestMapper;
import com.soul.shop.buyer.pojo.Test;
import com.soul.shop.buyer.service.ArticleService;
import javax.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 加 duoob注解， 发布当前的service服务到nacos上
 * ip:port/接口名称/方法名称
 * version便于接口有不同的实现，或者版本升级之用
 * interfaceClass 不加这个，事务无法使用
 */
@DubboService(version = "1.0.0", interfaceClass = ArticleService.class)
public class ArticleServiceImpl implements ArticleService {

  @Resource
  private TestMapper testMapper;

  @Override
  public String findArticle() {
    Test test = testMapper.selectById(1);
    return test.toString();
  }
}
