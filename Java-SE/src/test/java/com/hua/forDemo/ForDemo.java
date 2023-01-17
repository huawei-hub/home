package com.hua.forDemo;

import org.junit.Test;

public class ForDemo {
    //1
    @Test
    public void testContinue(){
        for (int i = 0; i < 5; i++) {
            if (i == 3)
                continue;
            System.out.println("i = " + i);
        }
    }

    //2
    @Test
    public void test2(){
        long begin = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            int j = i * 16;
            System.out.print(j);
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("耗费时间：" + (end - begin));
    }
    //3
    @Test
    public void test3(){
        long begin = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            int j = i << 4;
            System.out.print(j);
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("耗费时间：" + (end - begin));
    }
}
