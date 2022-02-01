package com.soul.shop.model.buyer.enums;

import java.util.HashMap;
import java.util.Map;

public enum ClientType {

  PC(0, "pc"),
  H5(1, "h5"),
  WAP(2, "wap");

  private int code;
  private String message;

  private static final Map<Integer, ClientType> CODE_MAP = new HashMap<>(3);

  static {
    for (ClientType clientType: values()) {
      CODE_MAP.put(clientType.code, clientType);
    }
  }

  ClientType(int code, String message) {
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
