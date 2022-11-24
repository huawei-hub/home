package com.hua.demo;

import lombok.Data;
import org.junit.Test;

public class JsonTest {
    //1
    @Test
    public void test1(){
        Stu stu = new Stu();
        stu.setId(1);
        stu.setName("zhangsan");

    }
}

@Data
class Stu{
    private int id;
    private String name;
}
