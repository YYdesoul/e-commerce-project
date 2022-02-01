package com.soul.shop.model.buyer.vo.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRecommend implements Serializable {

    private String type;

    private String name;

    private String icon;

    private PageRecommendOption options;

    private String key;
}
