package com.nondo.springboot.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Configuration {

    public Docket accessToken() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api") //定义组
                .select() //选择路径和api会生产文档
                .apis(RequestHandlerSelectors.basePackage("com.nondo.springboot.controller")) //拦截的包路径
                .paths(PathSelectors.regex("/*/.*")) //拦截的路径接口
                .build() //创建
                .apiInfo(apiInfo()); //配置说明
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring boot web 篇") //标题
                .description("spring boot web 相关内容") //描述
                .termsOfServiceUrl("http://www.extlight.com")
                .contact(new Contact("baicai", "http://www.extlight.com", "2261344159@qq.com")) //联系
                .version("1.0")
                .build();
    }
}
