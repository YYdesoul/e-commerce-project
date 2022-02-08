package com.soul.shop.model.buyer.enums.goods;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品类型
 */
public enum GoodsTypeEnum {


    PHYSICAL_GOODS(1,"实物商品"),

    VIRTUAL_GOODS(2,"虚拟商品"),

    E_COUPON(3,"电子卡券");


    private int code;
    private String message;

    private static final Map<Integer, GoodsTypeEnum> CODE_MAP = new HashMap<>(3);

    static{
        for(GoodsTypeEnum goodsTypeEnum: values()){
            CODE_MAP.put(goodsTypeEnum.getCode(), goodsTypeEnum);
        }
    }

    GoodsTypeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static GoodsTypeEnum codeOf(int code){
        return CODE_MAP.get(code);
    }

}