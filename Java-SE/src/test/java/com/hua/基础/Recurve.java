package com.hua.基础;

import org.junit.Test;

//递归
public class Recurve {

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        System.out.println(f(50));
        long end = System.currentTimeMillis();
        System.out.println((end - start)+"ms");
    }

    static int f(int i) {
        if (i == 1 || i == 0) {
            return 1;
        }
        return f(i - 2) + f(i - 1);
    }

}
