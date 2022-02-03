package com.soul.shop.model.buyer.enums;

/**
 * 验证码资源枚举
 */
public enum VerificationSourceEnum {

    SLIDER("滑块"),
    RESOURCE("验证码源");

    private final String description;

    VerificationSourceEnum(String des) {
        this.description = des;
    }
}
