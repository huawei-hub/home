package com.hua.随机数;

import org.junit.Test;
//随机数概率变平方
public class ArithmeticDemo {
    //1
    @Test
    public void test1(){
        System.out.println(Math.random());
        System.out.println(Math.max(Math.random(), Math.random()));
    }

    private static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    private void printBinary(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    //3
    @Test
    public void test3(){
        int a = 5;
        int b = 1;
        printBinary(a);
        printBinary(b);
        System.out.println((a | b));
        System.out.println((a & b));
        System.out.println((a ^ b));
        System.out.println((1 << 1));
    }

    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            // 无进位的相加
            sum = a ^ b;
            // 进位信息
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    //4
    @Test
    public void test4(){
        System.out.println(add(2, 3));
    }
}
