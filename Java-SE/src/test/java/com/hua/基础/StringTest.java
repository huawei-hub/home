package com.hua.基础;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;

//字符串方法测试
public class StringTest {

    //测试获取指定字符下标
    @Test
    public void indexOf(){
        String str = "1234.21345";
        int i = str.indexOf('.');
        System.out.println("i = " + i);
        System.out.println(str.substring(0, (i + 3)));
    }

    //字符串根据下标截取
    @Test
    public void substr(){
        String a = "abcdefg";
        System.out.println(a.substring(2));
        System.out.println(a.substring(2, 3));
    }

    //判断集合是否为空
    @Test
    public void isEmpty(){
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        if (StringUtils.isEmpty(map)) {
            System.out.println("可以判断集合是否为空");
        }
        System.out.println("不能判断集合是否为空");
    }
}
