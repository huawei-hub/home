package com.hua.jwt.entity;

import com.hua.jwt.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private Gender sex;

    @Override
    public String toString() {
        return getId()+"\t"+getName()+"\t"+getSex().getGender();
    }
}
