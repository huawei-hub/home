package com.hua.creational.Singleton;

public class Singleton1 {
    //首先，将 new Singleton() 堵死
    private Singleton1() { }
    //创建私有静态实例，意味着这个类第一次使用的时候就会进行创建
    private static Singleton1 singleton = new Singleton1();

    public static Singleton1 getInstance() {
        return singleton;
    }
}
