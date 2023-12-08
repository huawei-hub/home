package com.hua.基础;

import com.hua.se.entity.Person;
import com.hua.se.entity.Stu;
import com.hua.se.enums.Gender;
import org.junit.Test;

public class StuTest {
    //测试对象
    @Test
    public void test1(){
        Person person = new Person();
        person.setId(1);
        person.setSex(Gender.MAN);
        person.setName("小李");
        System.out.println(person);
        change(person);
        System.out.println(person);
    }
    private void change(Person person) {
        person.setName("小丽");
        "abc".concat("123");
    }
}
