package com.hua.基础;

import com.hua.entity.Stu;
import lombok.Data;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

//反射相关知识
public class ClazzTest {

    //获取对象的3种方法
    @Test
    public void getClassObject(){
        //第一种获取Class对象的方法
        Class<Stu> zClass = Stu.class;
        System.out.println("方法一获取->zClass:" + zClass);
        //第二种获取Class对象的方法
        Stu stu = new Stu();
        Class<? extends Stu> aClass = stu.getClass();
        System.out.println("方法二获取->zClass:" +aClass);
        //第三种获取Class对象的方法
        Class<?> cClass = null;
        try {
            cClass = Class.forName("com.hua.entity.Stu");
            System.out.println("方法三获取->zClass:" +cClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取Class对象的方法，字段，构造器，注解，父类，接口等
    //获取Class对象的方法，字段，构造器，注解，父类，接口等
    @Test
    public void methodDome() throws Exception {
        Class<Stu> zClass = Stu.class;
        Stu stu = zClass.newInstance();
        Field name = zClass.getDeclaredField("name");
        name.setAccessible(true);
//        name.set("name","zhangsan");
        System.out.println("stu = " + stu);

        ClassLoader classLoader = zClass.getClassLoader();
        System.out.println("classLoader = " + classLoader);


        Package aPackage = zClass.getPackage();
        Class<?>[] interfaces = zClass.getInterfaces();
        Class<? super Stu> superclass = zClass.getSuperclass();
        Annotation[] declaredAnnotations = zClass.getDeclaredAnnotations();
        Field[] declaredFields = zClass.getDeclaredFields();
        Method[] declaredMethods = zClass.getDeclaredMethods();
        Constructor<?>[] declaredConstructors = zClass.getDeclaredConstructors();
    }

    //测试获取字段的方法
    @Test
    public void fieldDemo() throws Exception{
        Stu stu = new Stu("zhangsan",25);
        Class<? extends Stu> aClass = stu.getClass();
        Field name = aClass.getField("name");
        System.out.println(name);
        Field age = aClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(stu,30);
        System.out.println(age);

        Object o = name.get(stu);
        System.out.println("name = " + o);
        Object o1 = age.get(stu);
        System.out.println("age = " + o1);
    }

    //测试注解操作
    @Test
    public void annotationDemo(){
        Class<Stu> zClass = Stu.class;
        Data annotation = zClass.getAnnotation(Data.class);
        System.out.println("annotation = " + annotation);
    }

    //测试操作方法
    @Test
    public void methodDemo() throws Exception {
        Class<Stu> zClass = Stu.class;
        Stu stu = zClass.newInstance();
        Method get = zClass.getMethod("get", null);
        System.out.println("get = " + get);
        Method set = zClass.getDeclaredMethod("set", String.class);
        set.setAccessible(true);
        set.invoke(stu,"hello");
        System.out.println("set = " + set);

        Method method = Integer.class.getMethod("parseInt", String.class);
        System.out.println((int)method.invoke(null, "12345")-5);

    }


    //5
    @Test
    public void test5(){
        String str = "1234.21345";
        int i = str.indexOf('.');
        System.out.println("i = " + i);
        System.out.println(str.substring(0, (i + 3)));
    }

    //6
    @Test
    public void test6(){
        Map<String, String> getenv = System.getenv();
        for (String s : getenv.keySet()) {
            System.out.println(s + " -> " + getenv.get(s));
        }
    }
}
