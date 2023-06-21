package com.hua.数据结构;

import com.hua.jwt.util.TriKey;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

public class TriKeyDemo {

    TriKey<String, String, String, Integer>
            triKey = new TriKey<>();
    {
        triKey.put("188.8", "/trs6/ctmsx/STR00*.sql", "2018-05-05T12:00:01", 100);
        triKey.put("188.8", "/trs6/ctmsx/STR00*.sql", "2018-05-05T12:00:01", 200);
        triKey.put("188.9", "/trs6/ctmsx/STR00*.sql", "2018-05-05T12:00:01", 100);
        triKey.put("188.10", "/trs6/ctmsx/STR00*.sql", "2018-05-05T12:00:01", 100);
        triKey.put("188.10", "/trs6/ctmsx/STR10*.sql", "2018-05-05T12:00:01", 100);
    }
    //1
    @Test
    public void test1(){
        ArrayList<Integer> ints = triKey.get("188.8", "/trs6/ctmsx/STR00*.sql", "2018-05-05T12:00:01");
        ints.forEach(System.out::println);

        Set set = triKey.getSet();
        set.forEach(System.out::println);
    }
}
