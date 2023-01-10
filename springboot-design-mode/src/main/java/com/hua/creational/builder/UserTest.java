package com.hua.creational.builder;

import org.junit.Test;

public class UserTest {
    //测试建造者模式
    @Test
    public void test1(){
        User user = User.builder().
                name("张三").
                age(18).
                password("zhangsan123").
                nickName("法外狂徒").builder();
        System.out.println(user.toString());
    }
}
