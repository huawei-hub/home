package com.hua.demo;

import com.hua.entity.Person;
import com.hua.entity.Teacher;
import com.hua.enums.Gender;
import com.hua.enums.Subject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    //1
    @Test
    public void test1(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"张三", Gender.MAN));
        list.add(new Teacher(2,"小王", Gender.MAN,Subject.MATH));

        list.forEach(System.out::println);
    }
}
