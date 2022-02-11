package com.soul.shop.sso.controller;

import com.soul.shop.common.security.Token;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.enums.VerificationEnums;
import com.soul.shop.sso.service.MemberService;
import com.soul.shop.sso.service.VerificationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MembersController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private VerificationService verificationService;

    @PostMapping("/userLogin")
    public Result<Token> userLogin(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestHeader String uuid) {
        /**
         * 1. 登录之前校验滑块验证的结果
         * 2. 调用service 认证登录
         */
        if (verificationService.check(uuid, VerificationEnums.LOGIN)) {
            return this.memberService.usernameLogin(username, password);
        }

        return Result.fail(-999, "请重新验证");
    }

    @ApiOperation("刷新token")
    @GetMapping("/refresh/{refreshToken}")
    public Result<Object> refreshToken(@PathVariable String refreshToken) {
        return this.memberService.refreshToken(refreshToken);
    }
}
