package com.hua;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Demo {

    @Resource
    private RedisTemplate redisTemplate;
    //1
    @Test
    public void test1(){
//        redisTemplate.opsForValue().set("k2","v2");

        System.out.println("k2 ->" +redisTemplate.opsForValue().get("k2"));
        System.out.println("k1 ->" + redisTemplate.opsForValue().get("k1"));
    }
}
