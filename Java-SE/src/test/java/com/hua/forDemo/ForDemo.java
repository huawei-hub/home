package com.hua.forDemo;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ForDemo {
    //1
    @Test
    public void testContinue() {
        for (int i = 0; i < 5; i++) {
            if (i == 3)
                continue;
            System.out.println("i = " + i);
        }
    }

    //2
    @Test
    public void test2() {
        long begin = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            int j = i * 16;
            System.out.print(j);
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("耗费时间：" + (end - begin));
    }

    //3耗费时间
    @Test
    public void test3() {
        long begin = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            int j = i << 4;
            System.out.print(j);
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("耗费时间：" + (end - begin));
    }

    //
    @Test
    public void testForSleep() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //计数器（循环次数）
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    System.out.println("执行第" + finalI + "次 start");
                    Thread.sleep(3000);
                    System.out.println("执行第" + finalI + "次 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            countDownLatch.countDown();
        }
        //阻塞线程，直到调用N次，countDown()方法才释放线程
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //
    @Test
    public void test5(){
        if (false) {
            System.out.println("111");
        }
    }
}
