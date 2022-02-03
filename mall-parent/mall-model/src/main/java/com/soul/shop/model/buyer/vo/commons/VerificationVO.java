package com.soul.shop.model.buyer.vo.commons;

import com.soul.shop.model.buyer.vo.commons.slider.VerificationSourceVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerificationVO implements Serializable {
    /**
     * 资源
     */
    List<VerificationSourceVO> verificationResources;

    /**
     * 滑块资源
     */
    List<VerificationSourceVO> verificationSliders;
}
