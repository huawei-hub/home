package com.hua.demo;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StringUtilsDemo {
    //1
    @Test
    public void test1(){
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        if (StringUtils.isEmpty(map)) {
            System.out.println("可以判断集合是否为空");
        }
        System.out.println("不能判断集合是否为空");
    }

    //2
    @Test
    public void test2(){
        String a = "abcd";
        System.out.println(a.substring(1,2));
    }

    //3
    @Test
    public void test3(){
        Set<String> set = new HashSet<>();
        set.add("qwe");
        set.add("asd");
        set.add("zxc");
        set.add("rty");
        set.add("fgh");
        set.forEach(System.out::println);
        System.out.println("==========");
        for (String s : set) {
            if (s.equals("qwe")) {
                set.remove("qwe");
            }
        }

        set.forEach(System.out::println);
    }

    //4
    @Test
    public void test4(){
        Map<String,String> map = new ConcurrentHashMap();
        map.put("k1", "v1");
        map.put("k1", "v1");
        System.out.println(map.size());
    }


    //5
    @Test
    public void test5(){
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add("v1");
        set.add("v2");
        map.put("k1", set);
        Set<String> set2 = new HashSet<>();
        set2.add("v3");
        set2.add("v4");
        map.put("k2", set2);
        map.put("k3", new HashSet<>());

        Set<Map.Entry<String, Set<String>>> entries = map.entrySet();
        for (Map.Entry<String, Set<String>> entry : entries) {
            String k = entry.getKey();
            int i = 1;
            Set<String> value = entry.getValue();
            Iterator<String> it = value.iterator();
            while (it.hasNext()) {
                String next = it.next();
                System.out.println(k + "->" + next);
                i++;
            }
            if (i > 1) {
                System.out.println("k = " + k);
            }
        }
    }


}
