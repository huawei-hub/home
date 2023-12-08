package com.hua.循环;

import com.hua.se.entity.EntityTest;
import org.junit.Test;

import java.util.*;

//遍历map集合
public class MapDemo {

    Map<String, Object> map = new HashMap<>();
    {
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
    }
    //map循环方式一
    @Test
    public void mapLoop1(){
        Set<String> keyS = map.keySet();
        for (String key : keyS) {
            System.out.println(key + " - " + map.get(key));
        }
    }

    //map循环方式二
    @Test
    public void mapLoop2(){
        Set<String> keyS = map.keySet();
        Iterator<String> it = keyS.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + " - " + map.get(key));
        }
    }

    //map循环方式三
    @Test
    public void mapLoop3(){
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> map = it.next();
            System.out.println(map.getKey() + " - " + map.getValue());
        }
    }

    //map循环的方式四
    //此方法是将所有value装在一个集合里
    @Test
    public void mapLoop4(){
        Collection<Object> values = map.values();
        for (Object value : values) {
            System.out.println("方式四 - " + value);
        }
    }

    //删除map集合重元素
    @Test
    public void cleanMap() {
        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            if ("k2".equals(key))
                it.remove();
        }
        System.out.println(map.size());
    }

    //
    @Test
    public void test2(){
        Map<String, String> map = null;
        for (String s : map.keySet()) {
            System.out.println("s = " + s);
        }
    }

    //3
    @Test
    public void test3(){
        EntityTest entityTest = new EntityTest();
        System.out.println(entityTest.getAge());
    }

    public static <K, V> void removeCommonKeys(Map<K, V> map1, Map<K, V> map2) {
        Set<K> commonKeys = new HashSet<>(map1.keySet());
        commonKeys.retainAll(map2.keySet());

        map1.keySet().removeAll(commonKeys);
        map2.keySet().removeAll(commonKeys);
    }

    //删除两个map都存在的数据
    @Test
    public void testRemoveCommonKeys(){
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Value1");
        map1.put(2, "Value2");
        map1.put(3, "Value3");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(2, "Value2");
        map2.put(3, "Value3");
        map2.put(4, "Value4");

        removeCommonKeys(map1, map2);

        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);
    }
}
