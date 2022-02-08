package com.soul.shop.sso.handler;

import com.soul.shop.common.context.ThreadContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ThreadContextHolder.setHttpRequest(request);
        ThreadContextHolder.setHttpResponse(response);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ThreadContextHolder.setHttpRequest(request);
        ThreadContextHolder.setHttpResponse(response);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // ThreadLocal 线程变量隔离，会在每一个线程里面创建一个副本对象，每个线程互不影响
        // 但是如果用完不移除，会有内存泄漏的风险
        // Thread中， ThreadLocalMap -> ThreadLocal key, value 存入的值， ThreadLocal 弱引用
        ThreadContextHolder.remove();
    }
}
