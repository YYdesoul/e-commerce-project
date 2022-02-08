package com.soul.shop.common.utils.token;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.Key;

public class SecretKeyUtil {
    public static Key generalKey() {
        byte[] encodedKey = Base64.decodeBase64("bXN6bHVfMTIzYXNkYWRnYXVoZCFAIyQlNkFERkdHS0pIR1lURkRZVVM=");//自定义
        javax.crypto.SecretKey key = Keys.hmacShaKeyFor(encodedKey);
        return key;
    }

    public static SecretKey generalKeyByDecoders() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode("bXN6bHVfMTIzYXNkYWRnYXVoZCFAIyQlNkFERkdHS0pIR1lURkRZVVM="));
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(Base64.encodeBase64String("mszlu_123asdadgauhd!@#$%6ADFGGKJHGYTFDYUS".getBytes()));
        System.out.println(new String(SecretKeyUtil.generalKeyByDecoders().getEncoded()));
    }
}
