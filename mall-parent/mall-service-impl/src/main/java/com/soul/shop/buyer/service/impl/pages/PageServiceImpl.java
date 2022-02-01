package com.soul.shop.buyer.service.impl.pages;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.soul.shop.buyer.mapper.PageTemplateMapper;
import com.soul.shop.buyer.mapper.TemplateDetailMapper;
import com.soul.shop.buyer.service.PageService;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.enums.StatusEnum;
import com.soul.shop.model.buyer.pojo.PageTemplate;
import com.soul.shop.model.buyer.pojo.TemplateDetail;
import com.soul.shop.model.buyer.vo.pages.Carousel;
import com.soul.shop.model.buyer.vo.pages.DiscountAdvert;
import com.soul.shop.model.buyer.vo.pages.FirstAdvert;
import com.soul.shop.model.buyer.vo.pages.NavBar;
import com.soul.shop.model.buyer.vo.pages.NewGoodsSort;
import com.soul.shop.model.buyer.vo.pages.NotEnough;
import com.soul.shop.model.buyer.vo.pages.PageRecommend;
import com.soul.shop.model.buyer.vo.pages.TopAdvert;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0", interfaceClass = PageService.class)
public class PageServiceImpl implements PageService {

  @Resource
  private PageTemplateMapper pageTemplateMapper;

  @Resource
  private TemplateDetailMapper templateDetailMapper;

  /**
   * 1. 根据clientType和PageType 获取模板信息 ms_page_template: 模板id和名称.
   * 2. 根据id获取模板详细信息，获取到的是List.
   * 3.根据不同的模板类型，转换模板数据为对应的实体类.
   * 4. 封装为map进行返回即可.
   *
   * @param clientType
   * @param pageType
   * @return
   */
  @Override
  public Result findPageTemplate(Integer clientType, int pageType) {
    // step 1
    LambdaQueryWrapper<PageTemplate> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper
        .eq(PageTemplate::getClientType, clientType)
        .eq(PageTemplate::getPageType, pageType)
        .eq(PageTemplate::getStatus, StatusEnum.NORMAL.getCode());
    queryWrapper.last("limit 1");
    PageTemplate pageTemplate = pageTemplateMapper.selectOne(queryWrapper);

    if (pageTemplate == null) {
      return Result.fail(-999, "模板不存在");
    }

    // step 2
    Long id = pageTemplate.getId();
    LambdaQueryWrapper<TemplateDetail> detailQueryWrapper = new LambdaQueryWrapper<>();
    detailQueryWrapper
        .eq(TemplateDetail::getTemplateId, id)
        .eq(TemplateDetail::getStatus, StatusEnum.NORMAL.getCode());
    List<TemplateDetail> templateDetails = templateDetailMapper.selectList(detailQueryWrapper);
    HashMap<String, Object> map = new LinkedHashMap<>(8); // 一共8个种类，定义好会省空间

    // step 3 and 4
    templateDetails.forEach(
        templateDetail -> addTemplateDetail(templateDetail, map)
        );
    return Result.success(map);
  }

  private void addTemplateDetail(TemplateDetail templateDetail, Map<String ,Object> map) {
    //            PageTemplateVo pageTemplateVo = new PageTemplateVo();
    String templateData = templateDetail.getTemplateData();

    String templateType = templateDetail.getTemplateType();
    if ("topAdvert".equals(templateType)){
      TopAdvert topAdvert = JSON.parseObject(templateData, TopAdvert.class);
//                pageTemplateVo.setPageData(topAdvert);
      map.put(templateDetail.getTemplateType(),topAdvert);
    }
    if ("navBar".equals(templateType)){
      NavBar navBar = JSON.parseObject(templateData,NavBar.class);
      map.put(templateDetail.getTemplateType(),navBar);
//                pageTemplateVo.setPageData(navBar);
    }
    if ("carousel".equals(templateType)){
      Carousel carousel = JSON.parseObject(templateData,Carousel.class);
      map.put(templateDetail.getTemplateType(),carousel);
    }
    if ("discountAdvert".equals(templateType)){
      DiscountAdvert discountAdvert = JSON.parseObject(templateData, DiscountAdvert.class);
      map.put(templateDetail.getTemplateType(),discountAdvert);
    }
    if ("recommend".equals(templateType)){
      PageRecommend pageRecommend = JSON.parseObject(templateData,PageRecommend.class);
      map.put(templateDetail.getTemplateType(),pageRecommend);
    }
    if ("newGoodsSort".equals(templateType)){
      NewGoodsSort newGoodsSort = JSON.parseObject(templateData,NewGoodsSort.class);
      map.put(templateDetail.getTemplateType(),newGoodsSort);
    }
    if ("firstAdvert".equals(templateType)){
      FirstAdvert firstAdvert = JSON.parseObject(templateData,FirstAdvert.class);
      map.put(templateDetail.getTemplateType(),firstAdvert);
    }
    if ("notEnough".equals(templateType)){
      NotEnough notEnough = JSON.parseObject(templateData,NotEnough.class);
      map.put(templateDetail.getTemplateType(),notEnough);
    }
  }
}
