package com.hua.structural.proxy;

import com.hua.creational.factoryPattern.Food;
import org.junit.Test;

/**
 * 测试代理模式
 */
public class TestProxy {
    //
    @Test
    public void test(){
        FoodService foodService = new FoodServiceProxy();
        Food food = foodService.makeChicken();
    }
}
