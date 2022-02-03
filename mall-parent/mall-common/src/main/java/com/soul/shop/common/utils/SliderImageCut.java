package com.soul.shop.common.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class SliderImageCut implements Serializable {

    private String slidingImage;

    private String backImage;

    private int randomX;

    private int randomY;

    private int originalHeight;

    private int originalWidth;

    private int sliderHeight;

    private int sliderWidth;
}
