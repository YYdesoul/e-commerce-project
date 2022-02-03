package com.soul.shop.buyer.service;

import com.soul.shop.model.buyer.vo.commons.VerificationVO;

public interface VerificationSourceService {
    /**
     * 查询数据库，获取资源列表，得到资源列表和滑块列表
     * @return
     */
    VerificationVO findVerificationSource();
}
