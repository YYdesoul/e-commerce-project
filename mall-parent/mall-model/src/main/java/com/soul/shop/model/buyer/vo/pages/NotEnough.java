package com.soul.shop.model.buyer.vo.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotEnough implements Serializable {

    private String type;

    private String name;

    private String icon;

    private String key;

    private NotEnoughOption options;
}
