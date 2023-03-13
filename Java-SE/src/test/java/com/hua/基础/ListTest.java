package com.hua.基础;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//集合的方法测试
public class ListTest {

    //集合的非空方法测试
    @Test
    public void isEmpty(){
        Map map = new HashMap();
        List list = new ArrayList();
        System.out.println(CollectionUtils.isEmpty(map));
        System.out.println(CollectionUtils.isEmpty(list));
        System.out.println(list.isEmpty());
    }

    //测试转换数组
    @Test
    public void toArray(){
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("234");
        list.add("345");
        String[] arr = new String[]{};
        String[] arrStr = list.toArray(new String[]{});
        System.out.println(arrStr[2]);
    }

}
