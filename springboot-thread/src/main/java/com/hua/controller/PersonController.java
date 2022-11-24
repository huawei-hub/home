package com.hua.controller;

import com.hua.entity.User;
import com.hua.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@RestController
public class PersonController {
    @Resource
    private UserService userService;

    @GetMapping("find")
    public String find() {
        long l1 = System.currentTimeMillis();
        User user1 = userService.find(1L);
        User user2 = userService.find(2L);
        long l2 = System.currentTimeMillis();
        return "success -> " + (l2 - l1);
    }

    @GetMapping("finds")
    public String finds() {
        long l1 = System.currentTimeMillis();
        CompletableFuture<Boolean> future1 = CompletableFuture.supplyAsync(() -> {
            User user = userService.find(1L);
            return Boolean.TRUE;
        });
        CompletableFuture<Boolean> future2 = CompletableFuture.supplyAsync(() -> {
            User user = userService.find(2L);
            return Boolean.TRUE;
        });
        CompletableFuture.allOf(future1, future2);
        try {
            future1.get();
            future2.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        long l2 = System.currentTimeMillis();

        return "success -> " + (l2 - l1);
    }
}
