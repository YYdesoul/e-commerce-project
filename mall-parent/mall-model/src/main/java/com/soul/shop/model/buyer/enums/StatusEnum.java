package com.soul.shop.model.buyer.enums;

public enum StatusEnum {

  NORMAL(0,"正常"),
  DELETE(1,"删除");

  private int code;
  private String message;

  StatusEnum(int code, String message){
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}