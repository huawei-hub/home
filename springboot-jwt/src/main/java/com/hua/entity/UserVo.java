package com.hua.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserVo {

    private int id;
    private String username;
    private String password;
}
