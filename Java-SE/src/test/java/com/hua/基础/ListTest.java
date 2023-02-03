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
}
