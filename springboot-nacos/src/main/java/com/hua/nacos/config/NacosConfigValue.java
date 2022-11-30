package com.hua.nacos.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NacosConfigValue {

    //第一种
    @Resource
    private Environment env;

    @Bean
    public void getEnvironment() {
        System.out.println("abc:" + env.getProperty("abc"));
    }

    //第二种
    @Value("${aa.bb.cc}")
    private String aa;

    @Bean
    public void getValue() {
        JSONObject subscribeJson = JSONObject.parseObject(aa);
        Map<String, List<String>> subscribeMap = new HashMap<>();
        for (String nodeId : subscribeJson.keySet()) {
            String s = subscribeJson.get(nodeId).toString();
            List<String> list = JSONObject.parseArray(s, String.class);
            subscribeMap.put(nodeId, list);
        }

        System.out.println(subscribeMap.size() +" -> "+ subscribeMap.get("18091"));
    }

}
