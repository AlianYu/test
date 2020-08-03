package com.sunline.clhd.example;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: lihu
 * @Date: 2020/7/17 017 13:46
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.sunline"})
@EnableFeignClients(basePackages = {"com.sunline"})
@MapperScan("com.sunline.clhd.example.mapper")
@Slf4j
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
        log.info("====================================启动完成====================================");
    }
}
