package com.hua.creational.factoryPattern;

import org.junit.Test;
//第一步，我们需要选取合适的工厂，然后第二步基本上和简单工厂一样。
public class TestFactory {
    //简单工厂模式
    @Test
    public void test(){
        Food food = FoodFactory.makeFood("noodle");
    }
}
