package com.hua.structural.bridging;

public class BluePen implements DrawApi{
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用蓝色笔画图，radius:" + radius + "，x:" + x + "，y:" + y);
    }
}
