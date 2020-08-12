package com.springboot.springsecurity1;

import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"com.springboot.springsecurity1","com.springboot.springsecurity1.controller"})
@Api("启动类")
@SpringBootApplication
@EnableFeignClients // 开启Feign功能
@EnableEurekaServer //服务注册中心
@MapperScan("com.springboot.springsecurity1.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

