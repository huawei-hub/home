package com.hua.se.config;

public interface RedisService {
    void set(String key, String value);

    String get(String key);

    boolean delete(String key);

    Long getExpireTime(String key);
}
