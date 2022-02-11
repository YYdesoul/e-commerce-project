package com.soul.shop.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.soul.shop")
public class DubboApp {

  public static void main(String[] args) {
    SpringApplication.run(DubboApp.class, args);
  }
}
