package com.soul.shop.common.execption;

import com.soul.shop.common.enums.BusinessCodeEnum;
import lombok.Data;

/**
 * 全局业务异常类
 */
@Data
public class BusinessException extends RuntimeException {

    public static String DEFAULT_MESSAGE = "网络错误，请稍后重试！";

    /**
     * 异常消息
     */
    private String msg = DEFAULT_MESSAGE;

    /**
     * 错误码
     */
    private BusinessCodeEnum resultCode;

    public BusinessException(String msg) {
        this.resultCode = BusinessCodeEnum.DEFAULT_SYS_ERROR;
        this.msg = msg;
    }

    public BusinessException() {
        super();
    }

    public BusinessException(BusinessCodeEnum resultCode) {
        this.resultCode = resultCode;
    }

    public BusinessException(BusinessCodeEnum resultCode, String message) {
        this.resultCode = resultCode;
        this.msg = message;
    }

}