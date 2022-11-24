package com.hua.entity;

import lombok.Data;
import lombok.ToString;

//@Data
@ToString
public class Student {

    private Integer id;
    private String name;
    private char sex;
    private Integer age;
    private String profession;
    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(int sex) {
        if (sex == 1) {
            this.sex = '男';
        } else {
            this.sex = '女';
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
