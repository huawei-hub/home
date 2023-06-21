package com.hua.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @PostMapping("/testPost")
    public String testPost(@RequestBody Map<String, Object> map) {
        System.out.println(map.get("id"));
        System.out.println(map.get("name"));
        return "success";
    }
}
