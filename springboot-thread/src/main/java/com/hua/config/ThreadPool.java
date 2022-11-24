package com.hua.config;

import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ThreadPool {

    //获取单线程池
    //  单线程化的线程池中的任务是按照提交的次序顺序执行的
    //  只有一个线程的线程池
    //  池中的唯一线程的存活时间是无限的
    //  当池中的唯一线程正繁忙时，新提交的任务实例会进入内部的阻塞队列中，并且其阻塞队列是无界的
    //  适用场景：任务按照提交次序，一个任务一个任务地逐个执行的场景
    public ExecutorService getSingleThreadExecutor() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        return pool;
    }

    //获取固定线程池
    //  如果线程数没有达到“固定数量”，每次提交一个任务线程池内就创建一个新线程，直到线程达到线程池固定的数量
    //  线程池的大小一旦达到“固定数量”就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程
    //  在接收异步任务的执行目标实例时，如果池中的所有线程均在繁忙状态，新任务会进入阻塞队列中（无界的阻塞队列）
    public ExecutorService getFixedThreadPool() {
        ExecutorService pool = Executors.newFixedThreadPool(3);//创建含有3个线程的线程池
        return pool;
    }

    //可缓存线程池
    //  在接收新的异步任务target执行目标实例时，如果池内所有线程繁忙，此线程池就会添加新线程来处理任务
    //  线程池不会对线程池大小进行限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小
    //  如果部分线程空闲，也就是存量线程的数量超过了处理任务数量，就会回收空闲（60秒不执行任务）线程
    public ExecutorService getCachedThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();
        return pool;
    }

    //可调度线程池
    public ScheduledExecutorService getScheduledThreadPool() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        return pool;
    }

    //标准线程创建方式
    public ThreadPoolExecutor getThreadPoolExecutor() {
        return new ThreadPoolExecutor(
                5, //corePoolSize 核心（Core）线程池数量
                10, //maximumPoolSize用于设置最大线程数量
                10, //线程的最大空闲时长
                TimeUnit.MINUTES, //时间单位
                new ArrayBlockingQueue<>(10), //任务的排队队列
                new ThreadPoolExecutor.CallerRunsPolicy() //拒绝策略
        );
    }

}
