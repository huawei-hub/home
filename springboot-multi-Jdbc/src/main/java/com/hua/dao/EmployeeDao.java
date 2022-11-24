package com.hua.dao;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmployeeDao {
    private Integer id;
    private String name;
    private Integer salary;
    private Integer managerId;
}
