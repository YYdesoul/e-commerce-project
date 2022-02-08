package com.soul.shop.sso.api;

import com.soul.shop.common.security.AuthUser;
import com.soul.shop.model.buyer.vo.member.MemberVO;

public interface SSOApi {
    MemberVO findMemberById(Long id);

    AuthUser checkToken(String token);
}
