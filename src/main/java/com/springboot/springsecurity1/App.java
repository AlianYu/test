package com.springboot.springsecurity1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"com.springboot.springsecurity1","com.springboot.springsecurity1.controller"})
@SpringBootApplication
@EnableFeignClients // 开启Feign功能
@EnableEurekaServer
@MapperScan("com.springboot.springsecurity1.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

