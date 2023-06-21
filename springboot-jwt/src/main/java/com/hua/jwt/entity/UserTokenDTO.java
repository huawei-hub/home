package com.hua.jwt.entity;

import lombok.Data;

@Data
public class UserTokenDTO {
    private int id;
    private String username;
    private long gmtCreate;
}
