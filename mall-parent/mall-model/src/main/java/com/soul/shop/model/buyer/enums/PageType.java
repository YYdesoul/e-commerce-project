package com.soul.shop.model.buyer.enums;

public enum PageType {

  INDEX(0, "index"),
  STORE(1, "store");

  private int code;
  private String message;

  PageType(int code, String message) {
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
