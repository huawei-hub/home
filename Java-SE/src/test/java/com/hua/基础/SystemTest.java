package com.hua.基础;

import org.junit.Test;

import java.util.Map;

//系统相关的东西
public class SystemTest {

    //获取当前系统变量
    @Test
    public void envSystem(){
        Map<String, String> getenv = System.getenv();
        for (String s : getenv.keySet()) {
            System.out.println(s + " -> " + getenv.get(s));
        }
    }
}
