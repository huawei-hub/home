package com.hua.mybatisPlus;

import com.hua.mybatisPlus.dto.Teacher;
import com.hua.mybatisPlus.mapper.TeacherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTeacher {
    @Autowired
    private TeacherMapper teacherMapper;
    //1
    @Test
    public void test1(){
        List<Teacher> listByParam = teacherMapper.findListByParam();
        listByParam.forEach(System.out::println);
    }
}
