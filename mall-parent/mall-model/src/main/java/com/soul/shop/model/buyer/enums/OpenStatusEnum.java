package com.soul.shop.model.buyer.enums;

public enum OpenStatusEnum {

  OPEN(0,"open"),
  CLOSE(1,"close");

  private int code;
  private String message;

  OpenStatusEnum(int code, String message){
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