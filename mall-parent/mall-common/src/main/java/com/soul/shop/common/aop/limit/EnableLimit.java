package com.soul.shop.common.aop.limit;

import com.soul.shop.common.config.RedisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({LimitConfig.class, RedisConfig.class})
public @interface EnableLimit {
}
