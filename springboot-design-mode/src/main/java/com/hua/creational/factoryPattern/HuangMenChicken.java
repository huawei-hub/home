package com.hua.creational.factoryPattern;

public class HuangMenChicken implements Food {

    @Override
    public void addSpicy(String spicy) {
        System.out.println("黄焖鸡加" + spicy);
    }

    @Override
    public void addCondiment(String condiment) {
        System.out.println("黄焖鸡加" + condiment);
    }
}
