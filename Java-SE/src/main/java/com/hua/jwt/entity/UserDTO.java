package com.hua.jwt.entity;

import lombok.Data;

@Data
public class UserDTO {

    /**
     * 姓名
     */
    private  String name;
    /**
     * 年龄
     */
    private  Integer age;
    /**
     * 性别
     */
    private  String sex;
    /**
     * 是否有方向
     */
    private  Boolean hasOrientation;

}
