package com.soul.shop.buyer.handler.security;

import com.soul.shop.sso.api.SSOApi;
import com.soul.shop.common.security.AuthUser;
import com.soul.shop.common.utils.ResponseUtil;
import com.soul.shop.common.utils.token.SecurityKey;
import com.soul.shop.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 认证结果过滤器
 */
@Slf4j
public class BuyerAuthenticationFilter extends BasicAuthenticationFilter {

    private StringRedisTemplate redisTemplate;

    private SSOApi ssoApi;

    /**
     * 自定义构造器
     *
     * @param authenticationManager
     * @param redisTemplate
     */
    public BuyerAuthenticationFilter(AuthenticationManager authenticationManager, StringRedisTemplate redisTemplate, SSOApi ssoApi) {
        super(authenticationManager);
        this.redisTemplate = redisTemplate;
        this.ssoApi = ssoApi;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 从header中获取jwt
        String jwt = request.getHeader(SecurityKey.ACCESS_TOKEN);
        try {
            // 如果没有token 则return
            if (StringUtils.isBlank(jwt)) {
                chain.doFilter(request, response);
                return;
            }
            // 获取用户信息， 存入context
            UsernamePasswordAuthenticationToken authentication = getAuthentication(jwt, response);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            log.error("BuyerAuthenticationFilter -> member authentication exception: ", e);
        }
        chain.doFilter(request, response);
    }

    /**
     * 解析用户
     *
     * @param jwt
     * @param response
     * @return
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String jwt, HttpServletResponse response) {
        try {
            AuthUser authUser = ssoApi.checkToken(jwt);

            if (authUser != null) {
                // 构造返回信息
                List<GrantedAuthority> auths = new ArrayList<>();
                auths.add(new SimpleGrantedAuthority("ROLE_" + authUser.getRole().name()));
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(authUser.getUsername(), null, auths);
                authentication.setDetails(authUser);
                return authentication;
            }
            ResponseUtil.output(response, 401, Result.noLogin());
            return null;
        } catch (Exception e) {
            log.error("user analysis exception: ", e);
        }
        return null;
    }
}
