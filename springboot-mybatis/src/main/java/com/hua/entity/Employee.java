package com.hua.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {
    private Integer id;
    private String name;
    private Double salary;
    private Integer manageId;
}
