package com.soul.shop.model.buyer.vo.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountAdvert implements Serializable {

    private String type;

    private String name;

    private String icon;

    private DiscountAdvertOption options;

    private String key;
}
