package com.hua.creational.factoryPattern;

public class LanZhouNoodle implements Food {
    @Override
    public void addSpicy(String spicy) {
        System.out.println("牛肉面加" + spicy);
    }

    @Override
    public void addCondiment(String condiment) {
        System.out.println("牛肉面加" + condiment);
    }
}
