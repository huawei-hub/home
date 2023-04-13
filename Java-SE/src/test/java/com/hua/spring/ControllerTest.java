package com.hua.spring;

import com.hua.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//单元测试
@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = {com.hua.SEApplication.class}, properties = {"application.yml"})
public class ControllerTest {
    @Autowired
    private HelloController helloController;

    //测试Controller类
    @Test
    public void testHello(){
        String hello = helloController.hello();
        System.out.println("hello = " + hello);
    }
}
