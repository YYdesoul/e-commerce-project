package com.soul.shop.buyer.controller.common;

import com.soul.shop.buyer.service.common.VerificationService;
import com.soul.shop.common.aop.limit.LimitPoint;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.enums.VerificationEnums;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/slider")
@Api(tags = "滑块验证")
public class SliderImageController {

  @Autowired
  private VerificationService verificationService;

  @GetMapping("/{verificationEnums}")
  @ApiOperation("获取校验接口")
  @LimitPoint(name = "获取校验接口", key = "getSliderImage")
  public Result getSliderImage(@RequestHeader String uuid,
      @PathVariable("verificationEnums") Integer verificationEnums) {
    VerificationEnums verificationEnumsNew = VerificationEnums.codeOf(verificationEnums);
    return verificationService.createVerification(verificationEnumsNew, uuid);
  }

  @PostMapping("/LOGIN")
  @ApiOperation("验证码预校验")
  public Result getSliderImage(@RequestHeader String uuid, Integer verificationEnums,
      Integer xPos) {
    VerificationEnums verificationEnumsNew = VerificationEnums.codeOf(verificationEnums);
    return verificationService.preCheck(verificationEnumsNew, uuid, xPos);
  }
}
