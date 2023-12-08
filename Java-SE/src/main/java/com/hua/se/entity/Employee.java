package com.hua.se.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee implements Serializable {
    private String name;
    private Integer age;
    private String department;
    private String level;
}
