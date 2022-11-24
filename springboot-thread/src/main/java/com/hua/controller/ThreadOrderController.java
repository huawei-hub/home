package com.hua.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class ThreadOrderController {

    @GetMapping("/notOrder")
    public String notOrder() {
        Thread thread1 = new Thread(() -> System.out.println("a"));
        Thread thread2 = new Thread(() -> System.out.println("b"));
        Thread thread3 = new Thread(() -> System.out.println("c"));

        thread1.start();
        thread2.start();
        thread3.start();
        return "success";
    }

    @GetMapping("/order1")
    public String order1() {
        try {
            Thread thread1 = new Thread(() -> System.out.println("a"));
            Thread thread2 = new Thread(() -> System.out.println("b"));
            Thread thread3 = new Thread(() -> System.out.println("c"));

            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @GetMapping("/order2")
    public String order2() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Thread thread1 = new Thread(() -> System.out.println("a"));
        Thread thread2 = new Thread(() -> System.out.println("b"));
        Thread thread3 = new Thread(() -> System.out.println("c"));

        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        return "success";
    }
}
