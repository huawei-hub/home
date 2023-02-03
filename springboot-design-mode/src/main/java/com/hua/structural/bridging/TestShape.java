package com.hua.structural.bridging;

//测试桥接模式
public class TestShape {
    public static void main(String[] args) {
        Circle blueCircle = new Circle(2, 4, new BluePen());
        blueCircle.draw();

        Square redSquare = new Square(2, new RedPen());
        redSquare.draw();
    }
}
