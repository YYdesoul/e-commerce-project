package com.soul.shop.common.security;

import lombok.Data;

import java.io.Serializable;

/**
 * Token 实体类
 */
@Data
public class Token implements Serializable {
    /**
     * 访问token
     */
    private String accessToken;

    /**
     * 刷新token
     */
    private String refreshToken;

}