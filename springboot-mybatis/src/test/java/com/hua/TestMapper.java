package com.hua;

import com.hua.entity.Person;
import com.hua.mapper.fk.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMapper {
    @Resource
    private PersonMapper personMapper;

    //1
    @Test
    public void test1(){
        Person person = personMapper.findById(1);
        System.out.println(person);
    }
}
