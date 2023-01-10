package com.hua.creational.factory;

import com.hua.creational.factoryPattern.Food;

public interface FoodFactory {
    Food makeFood(String name);
}
