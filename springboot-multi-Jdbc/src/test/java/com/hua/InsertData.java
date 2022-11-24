package com.hua;

import com.hua.util.RandomName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InsertData {
    @Autowired
    JdbcTemplate jdbcTemplate;


    int[] grade= {2016,2017,2018,2019,2020};
    String[] pro= {"汉语言文学","文秘","思想政治教育","历史教育","英语","商务日语","学前教育","小学教育",
            "旅游管理与服务教育","财务会计教育","工商企业管理","数学与应用数学","计算机科学与技术","电子信息工程",
            "电气工程与自动化","生物科学","地理科学","化学","数学与应用数学","思想政治教育","环境设计"};

    //插入随机数据
    @Test
    public void insertData(){
        String sql = "insert into student (`stu_id`, `stu_name`, `stu_sex`, `stu_age`, `stu_pro`, `stu_grade`) " +
                "values (?,?,?,?,?,?)";
        int numMax=9999;
        int nummin=0000;
        //循环创建一百条

        for (int i = 0; i < 100000; i++) {
            int id = i+1;
            String name = RandomName.randomName(true, 3);
            int sex = new Random().nextInt(2);
            int age = new Random().nextInt(30);
            jdbcTemplate.update(sql,
                    id, name, sex, age, pro[new Random().nextInt(pro.length-1)], grade[new Random().nextInt(grade.length-1)]);
        }
    }

    @Test
    public void insertDatas(){
        StringBuffer sql = new StringBuffer("insert into student (`stu_id`, `stu_name`, `stu_sex`, `stu_age`, `stu_pro`, `stu_grade`) values ");
        for (int i = 0; i < 1000; i++) {
            String value = "( " + (i + 1) + ",'" +
                    RandomName.randomName(true, 3) + "'," +
                    new Random().nextInt(2) + "," +
                    new Random().nextInt(30) + ",'" +
                    pro[new Random().nextInt(pro.length - 1)] + "'," +
                    grade[new Random().nextInt(grade.length - 1)] + "),";
            sql.append(value);
        }
        String substring = sql.substring(0, sql.length() - 2);
        jdbcTemplate.update(substring);
    }


}
