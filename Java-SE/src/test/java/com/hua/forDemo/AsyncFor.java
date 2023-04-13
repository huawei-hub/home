package com.hua.forDemo;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//循环和线程
public class AsyncFor {

    //1
    @Test
    public void test1() throws ExecutionException, InterruptedException {
//        List<CompletableFuture<Void>> list = new ArrayList<>();
        CompletableFuture[] arr = new CompletableFuture[3];
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
                System.out.println("第" + finalI + "个start！！！");
                try {
                    Thread.sleep(1000*(finalI+1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第" + finalI + "个end！！！");
            });
            arr[i]=cf;
        }
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(arr);
        completableFuture.get();
    }


    //2
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("第cf1个start！！！");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第cf1个end！！！");
            return "第cf1个end";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("第cf2个start！！！");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第cf2个end！！！");
            return "第cf2个end";
        });

        CompletableFuture<Void> cf3 = CompletableFuture.allOf(cf1, cf2);
        System.out.println("执行全部完成："+ cf3.get());
    }

}
