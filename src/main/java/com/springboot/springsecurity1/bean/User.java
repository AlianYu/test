package com.springboot.springsecurity1.bean;

import ch.qos.logback.core.net.SyslogOutputStream;
import io.swagger.annotations.Api;

@Api("User测试实体类")
public class User {
    private String name;
    private int id;

    public User() {
        System.out.println("无参构造");
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
