package com.hua.demo.controller;

import com.hua.demo.dto.Order;
import com.hua.demo.dto.Person;
import com.hua.demo.event.BaseEvent;
import com.hua.demo.event.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("/sendOrder")
    public void sendOrder() {
//        applicationContext.publishEvent(new OrderEvent(new Order("why"), "add"));
        applicationContext.publishEvent(
                new BaseEvent<>(new Person("Tom"), "update"));
        applicationContext.publishEvent(
                new BaseEvent<>(new Order("say"), "insert"));
    }

}
