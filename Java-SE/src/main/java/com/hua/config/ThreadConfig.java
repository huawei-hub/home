package com.hua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(
                5, //主线程数
                10,//最大线程数
                10, //闲置线程存活时间
                TimeUnit.MINUTES, //单位
                new ArrayBlockingQueue<>(10), //队列长度
                //工厂
                new ThreadPoolExecutor.CallerRunsPolicy() //拒绝策略
        );
    }
}
