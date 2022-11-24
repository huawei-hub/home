package com.hua.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {
    private Integer id;
    private String name;
    private String phone;
    private char gender;

    public void setGender(int sex) {
        if (sex == 1) {
            this.gender = '男';
        } else if (sex == 0) {
            this.gender = '女';
        } else {
            this.gender = '无';
        }
    }
}
