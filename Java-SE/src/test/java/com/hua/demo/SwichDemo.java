package com.hua.demo;

import org.junit.Test;

public class SwichDemo {
    @Test
    public void test1() {
        String str = "3";
        System.out.println(get(str));
    }

    public String get(String str) {
        switch (str){
            case "1":
                return "1";
            case "2":
                return "2";
            case "3":
                return "3";
        }
        return null;
    }
}
