package com.hua.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class ThreadSecurityController {

    public String security() {
        List<String> list = new CopyOnWriteArrayList<>();
        Map<String, Object> map = new ConcurrentHashMap<>();
        return "success";
    }
}
