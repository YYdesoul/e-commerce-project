package com.soul.shop.common.enums;

/**
 * redis 限流类型
 */

public enum LimitTypeEnums {
    /**
     * 自定义key(即全局限流)
     */
    CUSTOMER,
    /**
     * 根据请求者IP（IP限流）
     */
    IP
}