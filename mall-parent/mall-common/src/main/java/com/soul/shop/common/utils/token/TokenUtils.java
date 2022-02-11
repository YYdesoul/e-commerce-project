package com.soul.shop.common.utils.token;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class TokenUtils {

    public static String createToken(String username, Object claim, Long expirationTime) {
        // JWT生成
        return Jwts.builder()
                //jwt 私有申明
                .claim(SecurityKey.USER_CONTEXT, JSON.toJSONString(claim))
                // jwt 主体
                .setSubject(username)
                // 失效时间 当前时间+过期分钟
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime * 60 * 1000))
                // 签名算法和秘钥
                .signWith(SecretKeyUtil.generalKey())
                .compact();


    }

    public static Claims parseToken(String refreshToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SecretKeyUtil.generalKeyByDecoders())
                    .parseClaimsJws(refreshToken)
                    .getBody();
            return claims;
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException e) {
            // token 过期 认证失败等
            log.error("token 过期，认证失败。");
            return null;
        }
    }
}
