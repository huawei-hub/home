package com.hua.creational.factory;

import com.hua.creational.factoryPattern.Food;

public class AmericanFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            Food a = new AmericanFoodA();
            a.addCondiment("加鸡腿a");
            return a;
        } else if (name.equals("B")) {
            Food b = new AmericanFoodA();
            b.addCondiment("加鸡腿b");
            return b;
        } else {
            return null;
        }
    }
}
