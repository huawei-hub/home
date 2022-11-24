package com.hua.scheduled.config;

import java.util.Map;

public class MyTreadLocal {

    private final static ThreadLocal<Map<String, Object>> myLocal = new ThreadLocal<>();

    public static String getId() {
        Map map = myLocal.get();
        return map.get("id").toString();
    }

    public static void setLocal(Map<String, Object> map) {
        myLocal.set(map);
    }

    public static Map<String, Object> getLocal() {
        return myLocal.get();

    }

    public static void remove() {
        myLocal.remove();
    }
}
