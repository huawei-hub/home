package com.hua.creational.Singleton;

public class Singleton2 {
    //首先，将 new Singleton() 堵死
    private Singleton2() { }
    // 和饿汉模式相比，这边不需要先实例化出来，注意这里的 volatile，它是必须的
    private static volatile Singleton2 instance = null;

    public static Singleton2 getInstance() {
        if (instance == null) {
            //加锁
            synchronized (Singleton2.class) {
                //这里也要加，要不然会出现并发问题
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

}
