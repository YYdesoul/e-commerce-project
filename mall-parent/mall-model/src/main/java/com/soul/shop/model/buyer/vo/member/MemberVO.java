package com.soul.shop.model.buyer.vo.member;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员
 */
@Data
@NoArgsConstructor
public class MemberVO implements Serializable {

    private String id;

    private String username;

    private String nickName;

    //1 男 0 女
    private Integer sex;
    //
    private Date birthday;
    //会员地址ID
    private String regionId;
    //会员地址
    private String region;

    private String mobile;
    //积分
    private Long point;

    private String face;

    private Boolean haveStore;

    private String storeId;

    //会员等级
    private String gradeId;
    //经验
    private Long experience;



}

