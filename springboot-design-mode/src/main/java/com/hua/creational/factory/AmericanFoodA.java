package com.hua.creational.factory;

import com.hua.creational.factoryPattern.Food;

public class AmericanFoodA implements Food {
    @Override
    public void addSpicy(String spicy) {
        System.out.println(spicy);
    }

    @Override
    public void addCondiment(String condiment) {
        System.out.println(condiment);
    }
}
