package com.hua.structural.bridging;


public class Square extends Shape {
    private int radius;

    public Square(int radius,DrawApi drawApi) {
        super(drawApi);
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawApi.draw(radius, 0, 0);
    }
}
