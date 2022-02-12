package com.soul.shop.buyer;

import com.soul.shop.common.aop.limit.EnableLimit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLimit
public class BuyerApp {

  public static void main(String[] args) {
    SpringApplication.run(BuyerApp.class, args);
  }

}
