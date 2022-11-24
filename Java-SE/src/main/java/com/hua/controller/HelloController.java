package com.hua.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController  {

    @GetMapping("/hello")
    public String hello() {
        return "hello word";
    }

    @GetMapping("/logAop")
    public String logAop(String param) {
        return "success -> " + param;
    }
}
