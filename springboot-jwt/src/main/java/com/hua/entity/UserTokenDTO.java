package com.hua.entity;

import lombok.Data;

@Data
public class UserTokenDTO {
    private int id;
    private String username;
    private long gmtCreate;
}