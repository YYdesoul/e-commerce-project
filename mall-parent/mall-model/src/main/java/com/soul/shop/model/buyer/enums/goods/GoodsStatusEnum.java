package com.soul.shop.model.buyer.enums.goods;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品类型枚举
 */
public enum GoodsStatusEnum {
    /**
     * 上架
     */
    UPPER(1,"上架"),
    /**
     * 下架
     */
    DOWN(2,"下架");

    private int code;
    private String message;

    private static final Map<Integer, GoodsStatusEnum> CODE_MAP = new HashMap<>(2);

    static{
        for(GoodsStatusEnum goodsStatusEnum: values()){
            CODE_MAP.put(goodsStatusEnum.getCode(), goodsStatusEnum);
        }
    }

    GoodsStatusEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static GoodsStatusEnum codeOf(int code){
        return CODE_MAP.get(code);
    }
}