package com.hua.structural.bridging;

public class Circle extends Shape {

    private int x;
    private int y;

    public Circle(int x, int y, DrawApi drawApi) {
        super(drawApi);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawApi.draw(0, x, y);
    }
}
