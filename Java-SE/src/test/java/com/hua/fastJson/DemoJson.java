package com.hua.fastJson;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoJson {
    //1
    @Test
    public void test1(){
        String nodeId = "12306";
        List<String> list = new ArrayList<>();
        list.add("tab1");
        list.add("tab2");
        list.add("tab3");

        Map<String, List<String>> map = new HashMap<>();
        map.put(nodeId, list);

        String s = JSONObject.toJSONString(map);
        System.out.println(s);
    }
}
