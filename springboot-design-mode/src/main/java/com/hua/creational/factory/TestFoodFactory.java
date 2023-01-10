package com.hua.creational.factory;

import com.hua.creational.factoryPattern.Food;
import org.junit.Test;

public class TestFoodFactory {
    //工厂模式
    @Test
    public void test(){
        FoodFactory foodFactory = new AmericanFoodFactory();
        Food food = foodFactory.makeFood("B");
    }
}
