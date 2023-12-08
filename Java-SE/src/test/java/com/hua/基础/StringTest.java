package com.hua.基础;

import cn.hutool.json.JSONObject;
import com.hua.se.entity.Stu;
import org.junit.Test;
import org.springframework.util.ObjectUtils;
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
        System.out.println(a.substring(0,a.length()-1));
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
    //分割字符串
    @Test
    public void split(){
        String str = "center..table";
        String[] split = str.split("\\.\\.");
        System.out.println(split[1]);
    }
    //获取字符串的hash值
    @Test
    public void getHash(){
        String str = "abc";
        int i = str.hashCode();
//        System.out.println("i = " + i);
        Stu stu1 = new Stu("zhangsan", 24);
        Stu stu2 = new Stu("lisi", 24);


        String str1 = new JSONObject(stu1).toString();
        String str2 = new JSONObject(stu2).toString();

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }

    //分割符
    @Test
    public void testSplit(){
        String sql = "select 1";
        String[] split = sql.split(";");
        System.out.println("split = " + split);
    }

    //空置字符串
    @Test
    public void testLength(){
        StringBuilder sf = new StringBuilder();
        sf.append("hello");
        sf.append("word");
        System.out.println("第一次：" + sf.toString());
        sf.setLength(0);
        System.out.println("第二次：" + sf.toString());
    }

    //删除最后元素
    @Test
    public void testDelLast(){
        StringBuilder sb = new StringBuilder("abc@@def@@");
        StringBuilder result = sb.delete(sb.lastIndexOf("@@"), sb.lastIndexOf("@@") + "@@".length());
        System.out.println("result = " + result);
    }

    //ObjectUtils判断字符串空
    @Test
    public void testObjectUtilsIsEmpty(){
        System.out.println("null:" + ObjectUtils.isEmpty(null));
        System.out.println("空串:" + ObjectUtils.isEmpty(new Object()));
    }

    //右移
    @Test
    public void testRight(){
        int a = 2;
        int b = a >> 3;
        System.out.println("b = " + b);
    }
}
