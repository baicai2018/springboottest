package com.nondo.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class BeanConfiguration {
    @Bean
    @Profile("dev")
    public Runnable test1() {
        System.out.println("开发环境使用的 Bean");
        return () -> {
            System.out.println("开发环境使用的 Bean");
        };
    }

    @Bean
    @Profile("qos")
    public Runnable test2() {
        System.out.println("测试环境使用的 Bean");
        return () -> {
            System.out.println("测试环境使用的 Bean");
        };

    }

    @Bean
    @Profile("prod")
    public Runnable test3() {
        System.out.println("生成环境使用的 Bean");
        return () -> {
            System.out.println("生成环境使用的 Bean");
        };
    }
}