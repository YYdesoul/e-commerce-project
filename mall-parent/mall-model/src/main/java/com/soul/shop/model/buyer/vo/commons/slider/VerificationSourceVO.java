package com.soul.shop.model.buyer.vo.commons.slider;

import lombok.Data;

import java.io.Serializable;

@Data
public class VerificationSourceVO implements Serializable {

    private Long id;

    private String name;

    private String resource;

    private String type;
}
