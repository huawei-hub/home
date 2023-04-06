package com.hua;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncCompletableFuture {
    CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
        System.out.println(Thread.currentThread() + " cf1 do something....");
        return 1;
    });

    //
    @Test
    public void thenApplyTest1() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf2 = cf1.thenApply((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            result += 2;
            return result;
        });
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());

    }

    @Test
    public void thenApplyTest2() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf2 = cf1.thenApplyAsync((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            result += 2;
            return result;
        });
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    @Test
    public void thenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf2 = cf1.thenAccept((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }


    @Test
    public void thenAcceptAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf2 = cf1.thenAcceptAsync((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    @Test
    public void thenRunTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf2 = cf1.thenRun(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    @Test
    public void thenRunAsyncTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf2 = cf1.thenRunAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    CompletableFuture<Integer> cfError = CompletableFuture.supplyAsync(() -> {
        System.out.println(Thread.currentThread() + " cf1 do something....");
//        int a = 1/0;
        return 1;
    });

    @Test
    public void whenCompleteTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf2 = cfError.whenComplete((result, e) -> {
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

//        //等待任务1执行完成
//        System.out.println("cf1结果->" + cf1.get());
//        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    @Test
    public void handle() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf2 = cfError.handle((result, e) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            return result+2;
        });

        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }
}
