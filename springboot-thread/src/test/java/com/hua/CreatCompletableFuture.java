package com.hua;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreatCompletableFuture {

    //创建异步任务有返回值，使用默认线程
    @Test
    public void creatAsync1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("do something....");
            return "result";
        });
        //等待任务执行完成
        System.out.println("结果->" + cf.get());
    }

    //创建异步任务有返回值，使用自带线程
    @Test
    public void creatAsync2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("do something....");
            return "result";
        },executorService);
        //等待任务执行完成
        System.out.println("结果->" + cf.get());
    }

    //创建异步任务没有返回值，使用默认线程
    @Test
    public void creatAsync3() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("do something....");
        });
        //等待任务执行完成
        System.out.println("结果->" + cf.get());
    }
    //创建异步任务没有返回值，使用自定义线程
    @Test
    public void creatAsync4() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("do something....");
        },executorService);
        //等待任务执行完成
        System.out.println("结果->" + cf.get());
    }

}
