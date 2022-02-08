package com.soul.shop.sso.service;

import com.alibaba.fastjson.JSON;
import com.soul.shop.common.cache.CachePrefix;
import com.soul.shop.common.security.AuthUser;
import com.soul.shop.common.security.UserEnums;
import com.soul.shop.common.utils.token.SecretKeyUtil;
import com.soul.shop.common.utils.token.SecurityKey;
import com.soul.shop.model.buyer.enums.VerificationEnums;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VerificationService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean check(String uuid, VerificationEnums verificationEnums) {
        Boolean hasKey = redisTemplate.hasKey("VERIFICATION_IMAGE_RESULT_" + verificationEnums.name() + uuid);
        if (hasKey == null) {
            return false;
        }
        return hasKey;
    }

    public AuthUser checkToken(String token) {
        try {
            Claims claims =
                    Jwts.parser()
                            .setSigningKey(SecretKeyUtil.generalKey())
                            .parseClaimsJws(token).getBody();
            // 获取存储在claims中的用户信息
            String json = claims.get(SecurityKey.USER_CONTEXT).toString();
            AuthUser authUser = JSON.parseObject(json, AuthUser.class);

            // 校验redis中是否有权限
            Boolean hasKey = redisTemplate.hasKey(CachePrefix.ACCESS_TOKEN.name() + UserEnums.MEMBER.name() + token);
            if (hasKey != null && hasKey) {
                return authUser;
            }
        } catch (ExpiredJwtException e) {
            // token 过期了
            log.debug("user analysis exception: ", e);
        }
        return null;
    }
}
