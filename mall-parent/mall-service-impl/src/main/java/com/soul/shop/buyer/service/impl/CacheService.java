package com.soul.shop.buyer.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public <T> T get(String key, Class<T> clazz) {
        String redisValue = redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(redisValue)) {
            return null;
        }
        T parseObject = JSON.parseObject(redisValue, clazz);
        return parseObject;
    }

    public void set(String key, Object data, Long expire) {
        if (expire == null) {
            redisTemplate.opsForValue().set(key, JSON.toJSONString(data));
        } else {
            redisTemplate.opsForValue().set(key, JSON.toJSONString(data), expire, TimeUnit.SECONDS);
        }
    }
}
