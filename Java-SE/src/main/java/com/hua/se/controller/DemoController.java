package com.hua.se.controller;

import com.hua.se.config.DynamicScheduledTaskManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class DemoController {

    @Resource
    private DynamicScheduledTaskManager taskManager;

    @GetMapping("add1")
    public void add1() {
        // 添加定时任务
        taskManager.scheduleTask("task1", () -> System.out.println("Task 1 is running..."), 0, 5, TimeUnit.SECONDS);
    }

    @GetMapping("add2")
    public void add2() {
        // 添加另一个定时任务
        taskManager.scheduleTask("task2", () -> System.out.println("Task 2 is running..."), 0, 10, TimeUnit.SECONDS);
    }

    @GetMapping("delete")
    public void delete() {
        // 取消定时任务
        taskManager.cancelTask("task1");
    }

}
