package com.soul.shop.model.buyer.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * VerificationEnums
 */
public enum VerificationEnums {

    LOGIN(1,"登录"),
    REGISTER(2,"注册"),
    FIND_USER(3,"找回用户"),
    UPDATE_PASSWORD(4,"找回密码"),
    WALLET_PASSWORD(5,"支付钱包密码");

    private int code;
    private String message;

    private static final Map<Integer, VerificationEnums> CODE_MAP = new HashMap<>(3);

    static{
        for(VerificationEnums verificationEnums: values()){
            CODE_MAP.put(verificationEnums.getCode(), verificationEnums);
        }
    }

    VerificationEnums(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static VerificationEnums codeOf(int code){
        return CODE_MAP.get(code);
    }
}

