package com.hua.structural.adapter;

import org.junit.Test;

public class TestDuck {
    //测试对象适配模式
    @Test
    public void test(){
        Cock cock = new WildCock();
        Duck duck = new CockAdapter(cock);
        duck.fly();
        duck.quack();
    }
}
