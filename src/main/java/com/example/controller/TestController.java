package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class TestController {
    @RequestMapping("/haha")
    public String haha(){
        System.out.println("hahaha");
        return "loging";
    }
}
