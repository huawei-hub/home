package com.hua.基础;

import org.junit.Test;

import java.util.*;

public class MapTest {

    private Map<String, Set<String>> map = new HashMap<>();
    {
        Set<String> set = new HashSet<>();
        set.add("v1");
        set.add("v2");
        map.put("k1", set);
        Set<String> set2 = new HashSet<>();
        set2.add("v3");
        set2.add("v4");
        map.put("k2", set2);
        map.put("k3", new HashSet<>());
    }


    //删除map中元素，需要使用迭代器删除
    @Test
    public void remove(){
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (key.equals("k1")) {
                it.remove();
                continue;
            }
            System.out.println(key + " -> " + map.get(key));
        }
        System.out.println("key1是否存在："+ map.containsKey("k1"));
    }
}
