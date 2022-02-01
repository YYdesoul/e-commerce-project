package com.soul.shop.model.buyer.vo.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewGoodsSortOption implements Serializable {

    private PageContent left;

    private PageContent middle;

    private PageContent right;
}
