package com.hua.demo.controller;

import com.hua.demo.service.PublishService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PublishController {

    @Resource
    private PublishService publishService;

    @GetMapping("/sendMsg")
    public String sendMsg(Integer nodeId) {
        boolean flag = publishService.sendMsg(nodeId);
        return flag ? "success" : "false";
    }

}
