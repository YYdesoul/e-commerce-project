package com.soul.shop.buyer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

  @Bean(value = "defaultApi2")
  public Docket defaultApi2() {
    Docket docket=new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(new ApiInfoBuilder()
            .title("码神商城API列表")
            .description("码神商城 rest API列表")
            .termsOfServiceUrl("https://mall.soul.com/")
            .contact(new Contact("yysoul","","mall@soul.com"))
            .version("1.0")
            .build())
        //分组名称
        .groupName("3.X版本")
        .select()
        //这里指定Controller扫描包路径
        .apis(RequestHandlerSelectors.basePackage("com.soul.shop.buyer.controller"))
        .paths(PathSelectors.any())
        .build();
    return docket;
  }
}
