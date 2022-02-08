package com.soul.shop.model.buyer.enums.goods;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品审核
 */
public enum GoodsAuthEnum {
    /**
     * 需要审核 并且待审核
     */
    TOBEAUDITED(1,"待审核"),
    /**
     * 审核通过
     */
    PASS(2,"审核通过"),
    /**
     * 审核通过
     */
    REFUSE(3,"审核拒绝");
    private int code;
    private String message;

    private static final Map<Integer, GoodsAuthEnum> CODE_MAP = new HashMap<>(3);

    static{
        for(GoodsAuthEnum goodsAuthEnum: values()){
            CODE_MAP.put(goodsAuthEnum.getCode(), goodsAuthEnum);
        }
    }

    GoodsAuthEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static GoodsAuthEnum codeOf(int code){
        return CODE_MAP.get(code);
    }
}
