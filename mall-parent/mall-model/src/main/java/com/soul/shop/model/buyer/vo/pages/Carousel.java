package com.soul.shop.model.buyer.vo.pages;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Carousel implements Serializable {

    private String type;

    private String name;

    private String icon;

    private String showName;

    private String size;

    private CarouselOption options;

    private String key;

}
