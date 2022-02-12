package com.soul.shop.common.aop.limit;

import com.google.common.collect.ImmutableList;
import com.soul.shop.common.enums.BusinessCodeEnum;
import com.soul.shop.common.enums.LimitTypeEnums;
import com.soul.shop.common.execption.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Slf4j
@Configuration
@Aspect // AOP切面定义 定义了切点和通知的关系
public class LimitInterceptor {

    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private DefaultRedisScript<Long> limitScript;

    // <Object, Object> 和 <String, Serializable> 不匹配，无法自动注入，需要使用set方法
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // 切点
    @Pointcut("@annotation(LimitPoint)")
    public void pt(){}

    /**
     * 通知类型
     * 限流 方法访问之前进行限流判断
     */
    @Before("@annotation(limitPoint)")
    public void limit(LimitPoint limitPoint) {
        // 限流的数
        int limit = limitPoint.limit();
        // 时间
        int period = limitPoint.period();
        String key = limitPoint.key();
        LimitTypeEnums limitTypeEnums = limitPoint.limitType();

        // 判断一下如果type类型为ip， key = key+ip
        if (limitTypeEnums.equals(LimitTypeEnums.IP)) {
            key = key + getIpAddress();
        }
        /**
         * 限流
         * 1. redis 自增
         * 2. 设定redis的过期时间
         * 3. 如果value大于最大值就拒绝请求
         * 4. 规定时间内没有访问就自动删除缓存
         */
        // 1, 使用redis的事务 2. 使用lua脚本
        ImmutableList<String> keyList = ImmutableList.of(StringUtils.join(limitPoint.prefix() + key));
        Long count = redisTemplate.execute(limitScript, keyList, limit, period);
        log.info("限流的接口：{}, 访问次数: {}, 限流的次数：{}, key: {} ", limitPoint.name(), count, limit, key);
        if (count == null || count >= limit) {
            throw new BusinessException(BusinessCodeEnum.LIMIT_ERROR);
        }
    }

    /**
     * 默认unknown常量值
     */
    private static final String UNKNOWN = "unknown";

    /**
     * 获取ip
     * @return ip
     */
    public String getIpAddress() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
