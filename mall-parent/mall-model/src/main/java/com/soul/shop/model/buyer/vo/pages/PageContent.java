package com.soul.shop.model.buyer.vo.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageContent implements Serializable {
    private String title;

    private String secondTitle;

    private String bgColor;

    private String url;

    private List<PageContentImageData> list;
}
