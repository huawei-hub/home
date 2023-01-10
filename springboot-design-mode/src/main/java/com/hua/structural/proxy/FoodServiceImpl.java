package com.hua.structural.proxy;

import com.hua.creational.factoryPattern.Chicken;
import com.hua.creational.factoryPattern.Food;
import com.hua.creational.factoryPattern.Noodle;

public class FoodServiceImpl implements FoodService {
    public Food makeChicken() {
        Food f = new Chicken();
        f.addSpicy("1g");
        f.addCondiment("3g");
        return f;
    }

    public Food makeNoodle() {
        Food f = new Noodle();
        f.addSpicy("500g");
        f.addCondiment("5g");
        return f;
    }
}
