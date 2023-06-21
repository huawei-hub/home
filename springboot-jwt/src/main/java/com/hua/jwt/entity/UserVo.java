package com.hua.jwt.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserVo {

    private int id;
    private String username;
    private String password;
}
