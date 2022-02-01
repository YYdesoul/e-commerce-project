package com.soul.shop.model.buyer.vo.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageContentImageData implements Serializable {

    private String img;

    private String name;

    private String describe;

    private String url;

    private String size;

    private BigDecimal price;

}
