package com.soul.shop.sso.api;

import com.soul.shop.common.security.AuthUser;
import com.soul.shop.model.buyer.vo.member.MemberVO;
import com.soul.shop.sso.service.MemberService;
import com.soul.shop.sso.service.VerificationService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(version = "1.0.0", interfaceClass = SSOApi.class)
public class SSOApiImpl implements SSOApi {

    @Autowired
    private MemberService memberService;

    @Autowired
    private VerificationService verificationService;

    @Override
    public MemberVO findMemberById(Long id) {
        return memberService.findMemberById(id);
    }

    @Override
    public AuthUser checkToken(String token) {
        return verificationService.checkToken(token);
    }
}
