package com.hua.jwt.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Stu implements Serializable {
    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String name;
    private int age;

    public Stu() {
    }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void get() {
        System.out.println("执行get方法！");
    }

    private void set(String message) {
        System.out.println("执行set方法！！" + message);
    }
}
