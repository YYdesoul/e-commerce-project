package com.soul.shop.buyer.service.members;

import com.soul.shop.buyer.handler.security.UserContext;
import com.soul.shop.sso.api.SSOApi;
import com.soul.shop.common.security.AuthUser;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.vo.member.MemberVO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class MemberBuyerService {

    @DubboReference(version = "1.0.0")
    private SSOApi ssoApi;

    /**
     * 1. 通过spring security获取到authUser
     * 2. 通过sso的dubbo服务获取到member信息
     * @return
     */
    public Result<MemberVO> getUserInfo() {
        AuthUser currentUser = UserContext.getCurrentUser();
        if (currentUser != null) {
            String id = currentUser.getId();
            MemberVO memberById = ssoApi.findMemberById(Long.parseLong(id));
            return Result.success(memberById);
        }
        return Result.fail(-999, "登录已过期");
    }
}
