package com.soul.shop.sso.handler;

import com.soul.shop.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class BusinessExceptionHandler {

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public Result doException(Exception e) {
    e.printStackTrace();
    log.error("出异常了： {}", e.getMessage());
    return Result.fail();
  }
}
