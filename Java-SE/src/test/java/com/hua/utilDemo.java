package com.hua;

import com.hua.entity.Student;
import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.util.Properties;

public class utilDemo {
    //断言
    @Test
    public void test(){
        Assert.notNull("root","没问题");
        Assert.notNull(null,"有没问题");
    }

    //反射
    @Test
    public void test2(){
        System.out.println(ReflectionUtils.findMethod(Student.class, "setId",String.class));
//        for (int i = 0; i < ReflectionUtils.getAllDeclaredMethods(Student.class).length; i++) {
//            System.out.println(ReflectionUtils.getAllDeclaredMethods(Student.class)[i]);
//        }
        Student student = new Student();
        Method getId = ReflectionUtils.findMethod(student.getClass(), "getId");
        System.out.println("getId = " + getId);
        System.out.println(ReflectionUtils.invokeMethod(getId, student));
        Method setId = ReflectionUtils.findMethod(student.getClass(), "setId",String.class);
        ReflectionUtils.invokeMethod(setId, student, "123");
        System.out.println(ReflectionUtils.invokeMethod(getId, student));

    }

    //3
    @Test
    public void test3(){
        Properties properties = System.getProperties();
        System.out.println("properties = " + properties);

        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("name = " + name);
    }
}
