package com.soul.shop.model.buyer.vo.pages;

import lombok.Data;

import java.io.Serializable;

@Data
public class TopAdvert implements Serializable {
    //跳转链接
    private String url;
    //topAdvert
    private String type;

    private String size;
    //图片
    private String img;

    private String bgColor;
}
