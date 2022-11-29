package com.hua.nacos.config;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

@Component
public class NacosConfigSampleRunner implements ApplicationRunner {

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        nacosConfigManager.getConfigService().addListener(
                "nacos-test.yml", "DEFAULT_GROUP", new Listener() {

                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        Properties properties = new Properties();
                        try {
                            properties.load(new StringReader(configInfo));
                            String map = properties.getProperty("zcbus.map");
                            System.out.println("abc = " + map);

                            JSONObject jsonOb = JSONObject.parseObject(map);
                            Map<String, List<String>> subscribeMap = new HashMap<>();
                            for (String nodeId : jsonOb.keySet()) {
                                String s = jsonOb.get(nodeId).toString();
                                List<String> list = JSONObject.parseArray(s, String.class);
                                subscribeMap.put(nodeId, list);
                            }

                            System.out.println(subscribeMap.size());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("config changed: " + properties);
                    }

                    @Override
                    public Executor getExecutor() {
                        return null;
                    }
                });
    }
}
