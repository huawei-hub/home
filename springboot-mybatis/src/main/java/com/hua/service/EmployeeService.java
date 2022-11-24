package com.hua.service;

import com.hua.entity.Employee;

import java.util.Map;

public interface EmployeeService {

    Employee findEmployee(Map<String, Object> map);

    int transaction();
}
