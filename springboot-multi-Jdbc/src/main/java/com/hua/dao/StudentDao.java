package com.hua.dao;

import com.hua.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class StudentDao {

    @Qualifier("fk")
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Student selectById(Integer id) {
        String sql = "select stu_id id,stu_name name, stu_sex sex, stu_age age,stu_pro profession, stu_grade grade " +
                "from student where stu_id = ?";
        return jdbcTemplate.queryForObject(sql, Student.class, id);
    }
}
