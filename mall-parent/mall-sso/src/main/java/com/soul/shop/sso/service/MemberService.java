package com.soul.shop.sso.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.soul.shop.buyer.mapper.MemberMapper;
import com.soul.shop.common.cache.CachePrefix;
import com.soul.shop.common.context.ThreadContextHolder;
import com.soul.shop.common.security.AuthUser;
import com.soul.shop.common.security.Token;
import com.soul.shop.common.security.UserEnums;
import com.soul.shop.common.utils.EnumUtil;
import com.soul.shop.common.utils.token.TokenUtils;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.enums.ClientType;
import com.soul.shop.model.buyer.pojo.Member;
import com.soul.shop.model.buyer.vo.member.MemberVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 1. 根据用户名查找Member信息
     * 2. 如果为null,就是用户不存在
     * 3. 密码进行匹配，如果不匹配，密码不正确
     * 4. 生成token
     * 5. jwt 生成token, token放入redis中， accessToken 过期短， refreshToken 过期长
     * @param username
     * @param password
     * @return
     */
    public Result<Token> usernameLogin(String username, String password) {
        LambdaQueryWrapper<Member> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Member::getUsername, username).eq(Member::getDisabled, false);
        Member member = memberMapper.selectOne(queryWrapper);
        if (member == null) {
            return Result.fail(-999, "用户不存在");
        }

        // security密码类
        if (!new BCryptPasswordEncoder().matches(password, member.getPassword())) {
            return Result.fail(-999, "密码错误");
        }

        // 一般会登录的时候，记录用户的最后一次登录时间
        // MQ 考虑使用mq,把信息发到mq当中，由mq的消费者去更新
        String clientType = ThreadContextHolder.getHttpRequest().getHeader("clientType").toUpperCase();

        if (StringUtils.isBlank(clientType)) {
            clientType = "pc";
        }

        ClientType type = EnumUtil.getEnumFromString(ClientType.class, clientType);
        if (type == null) {
            type = ClientType.UNKNOWN;
        }
        member.setClientEnum(type.getCode());
        member.setLastLoginDate(System.currentTimeMillis());
        this.memberMapper.updateById(member);

        Token token = genToken(member);
        return Result.success(token);
    }

    private Token genToken(Member member) {
        Token token = new Token();
        //accessToken refreshToken
        AuthUser authUser = new AuthUser(member.getUsername(), String.valueOf(member.getId()), member.getNickName(), UserEnums.MEMBER);
        String accessToken = TokenUtils.createToken(member.getUsername(), authUser, 7 * 24 * 60L);
        // 放入redis当中
        redisTemplate.opsForValue().set(
                CachePrefix.ACCESS_TOKEN.name() + UserEnums.MEMBER.name() + accessToken,
                "true",
                7, TimeUnit.DAYS);
        String refreshToken = TokenUtils.createToken(member.getUsername(), authUser, 15 * 24 * 60L);
        redisTemplate.opsForValue().set(
                CachePrefix.REFRESH_TOKEN.name() + UserEnums.MEMBER.name() + refreshToken,
                "true",
                15, TimeUnit.DAYS);
        token.setAccessToken(accessToken);
        token.setRefreshToken(refreshToken);
        return token;

    }

    public MemberVO findMemberById(long id) {
        LambdaQueryWrapper<Member> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Member::getId, id).eq(Member::getDisabled, false);
        Member member = memberMapper.selectOne(queryWrapper);
        return copy(member);
    }

    private MemberVO copy(Member member) {
        if (member == null) {
            return null;
        }
        MemberVO memberVO = new MemberVO();
        BeanUtils.copyProperties(member, memberVO);
        memberVO.setId(String.valueOf(member.getId()));
        return memberVO;
    }
}
