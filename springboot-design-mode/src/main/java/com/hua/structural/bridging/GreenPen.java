package com.hua.structural.bridging;

public class GreenPen implements DrawApi{
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用绿色笔画图，radius:" + radius + "，x:" + x + "，y:" + y);
    }
}
