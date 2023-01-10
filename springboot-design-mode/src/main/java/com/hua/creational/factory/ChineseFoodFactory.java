package com.hua.creational.factory;

import com.hua.creational.factoryPattern.Food;

public class ChineseFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            Food a = new ChineseFoodA();
            a.addSpicy("加辣a");
            return a;
        } else if (name.equals("B")) {
            Food b = new ChineseFoodA();
            b.addSpicy("加辣b");
            return b;
        } else {
            return null;
        }
    }
}
