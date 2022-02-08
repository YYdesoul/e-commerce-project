package com.soul.shop.buyer.handler.security;

import com.soul.shop.common.security.AuthUser;

public class UserContext {

    private static AuthenticationHandler authenticationHandler;

    public static void setHolder(AuthenticationHandler authenticationHandler) {
        UserContext.authenticationHandler = authenticationHandler;
    }

    public static AuthUser getCurrentUser() {
        return authenticationHandler.getAuthUser();
    }
}
