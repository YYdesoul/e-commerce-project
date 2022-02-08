package com.soul.shop.buyer.controller.members;

import com.soul.shop.buyer.service.members.MemberBuyerService;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.vo.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberBuyerController {

    @Autowired
    private MemberBuyerService memberBuyerService;

    @GetMapping
    public Result<MemberVO> getUserInfo() {
        return memberBuyerService.getUserInfo();
    }
}
