package com.soul.shop.model.buyer.vo.pages;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PageTemplateVo implements Serializable {

    private String type;

    private Object pageData;



}
