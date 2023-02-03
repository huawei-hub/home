package com.hua.基础;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//FastJson对于json串的一些操作
public class FastJsonTest {
    Map<String, List<String>> map = new HashMap<>();
    {
        List<String> list = new ArrayList<>();
        list.add("tab1");
        list.add("tab2");
        list.add("tab3");
        String nodeId = "12306";
        map.put(nodeId, list);
    }

    //转换为json
    @Test
    public void toJson(){
        String s = JSONObject.toJSONString(map);
        System.out.println(s);
    }
}
