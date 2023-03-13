package com.hua.基础;

import org.junit.Test;

//递归
public class Recurve {
    //斐波那契数列
    //f(0)=1
    //f(1)=1
    //f(2)=f(0)+f(1)
    //f(3)=f(1)+f(2)
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
