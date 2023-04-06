package com.hua;

import com.hua.dao.StudentDao;
import com.hua.entity.Employee;
import com.hua.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JDBCTest {

    @Qualifier("fk")
    @Autowired
    JdbcTemplate fkJdbcTemplate;

    @Test
    public void contextLoads() {
        List<Map<String, Object>> list = fkJdbcTemplate.queryForList("select * from employee", new BeanPropertyRowMapper<>(Employee.class));
        list.forEach(System.out::println);
    }

    //添加数据
    @Test
    public void insert(){
        int lose = fkJdbcTemplate.update("insert into employee values (?,?,?,?)", 5, "lose", 5400, 4);
        System.out.println("lose = " + lose);
    }

    //1
    @Test
    public void test1(){
        Integer integer = fkJdbcTemplate.queryForObject("select count(1) from student ", Integer.class);
        System.out.println(integer);
    }

    @Resource
    private StudentDao studentDao;

    //2
    @Test
    public void test2(){
        Student student = studentDao.selectById(2);
        System.out.println(student);
    }

    //3
    @Test
    public void test3(){
        String sql = "select stu_id id,stu_name name, stu_sex sex, stu_age age,stu_pro profession, stu_grade grade " +
                "from student where stu_id = ?";

        Student student1 = fkJdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setAge(rs.getInt("age"));
            student.setName(rs.getString("name"));
            student.setGrade(rs.getInt("grade"));
            student.setProfession(rs.getString("profession"));
            student.setSex(rs.getInt("sex"));
            return student;
        },2);

        System.out.println("student1 = " + student1);
    }

    //3
    @Test
    public void test4(){
        String sql = "select stu_id id,stu_name name, stu_sex sex, stu_age age,stu_pro profession, stu_grade grade " +
                "from student where stu_id = ?";

        List<Student> list = fkJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), 2);

        System.out.println(list.isEmpty() ? null : list.get(0));
    }

    @Qualifier("lk")
    @Autowired
    private JdbcTemplate lkJdbcTemplate;

    //4
    @Test
    public void test5(){
        lkJdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(
                        "insert into employee( id,name, salary, managerId) values (7,?,7000,3)");
                ps.setString(1,"王富贵");
                return ps;
            }
        });
    }


    //6
    @Test
    public void test6(){
        String sql = "insert into employee( id,name, salary, managerId) values (?,?,?,?)";
        lkJdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, 8);
                ps.setString(2,"张麻子");
                ps.setFloat(3,8000.0F);
                ps.setInt(4, 3);
            }
        });
    }

    //7
    @Test
    public void test7(){
        String sql = "select stu_id id,stu_name name, stu_sex sex, stu_age age,stu_pro profession, stu_grade grade " +
                "from student where stu_id = ?";
        lkJdbcTemplate.query(sql,
                new Object[] {2},
                new BeanPropertyRowMapper<>(Student.class));
    }

    //8
    @Test
    public void test8(){
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(lkJdbcTemplate);

    }

}
