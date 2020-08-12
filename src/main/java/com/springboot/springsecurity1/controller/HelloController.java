package com.springboot.springsecurity1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/login/a")
    public ModelAndView login(){
        System.out.println("-------访问login.html-------");
        return null;
    }

}
