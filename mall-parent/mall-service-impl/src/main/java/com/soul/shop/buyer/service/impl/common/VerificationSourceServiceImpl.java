package com.soul.shop.buyer.service.impl.common;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.soul.shop.buyer.mapper.VerificationSourceMapper;
import com.soul.shop.buyer.service.VerificationSourceService;
import com.soul.shop.model.buyer.enums.VerificationEnums;
import com.soul.shop.model.buyer.enums.VerificationSourceEnum;
import com.soul.shop.model.buyer.pojo.VerificationSource;
import com.soul.shop.model.buyer.vo.commons.VerificationVO;
import com.soul.shop.model.buyer.vo.commons.slider.VerificationSourceVO;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@DubboService(version = "1.0.0", interfaceClass = VerificationSourceService.class)
public class VerificationSourceServiceImpl implements VerificationSourceService {

    @Resource
    private VerificationSourceMapper verificationSourceMapper;

    @Override
    public VerificationVO findVerificationSource() {
        LambdaQueryWrapper<VerificationSource> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(VerificationSource::getDeleteFlag, false);
        List<VerificationSource> verificationSources = verificationSourceMapper.selectList(queryWrapper);

        List<VerificationSourceVO> resources = new ArrayList<>();
        List<VerificationSourceVO> sliders = new ArrayList<>();
        verificationSources.forEach(
                verificationSource -> {
                    if (verificationSource.getType().equals(VerificationSourceEnum.RESOURCE.name())) {
                        resources.add(copy(verificationSource));
                    } else if (verificationSource.getType().equals(VerificationSourceEnum.SLIDER.name())) {
                        sliders.add(copy(verificationSource));
                    }
                }
        );

        VerificationVO verificationVO = VerificationVO.builder()
                .verificationResources(resources)
                .verificationSliders(sliders)
                .build();

        return verificationVO;
    }

    public VerificationSourceVO copy(VerificationSource verificationSource){
        if (verificationSource == null){
            return null;
        }
        VerificationSourceVO VerificationSourceVO = new VerificationSourceVO();
        BeanUtils.copyProperties(verificationSource,VerificationSourceVO);
        return VerificationSourceVO;
    }
}
