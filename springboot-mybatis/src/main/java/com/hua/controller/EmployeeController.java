package com.hua.controller;

import com.hua.entity.Employee;
import com.hua.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/findEmployee")
    public String findEmployee() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("salary", 7000);
        Employee employee = employeeService.findEmployee(map);
        System.out.println(employee);
        return "success";
    }

    @PostMapping("/transaction")
    public String transaction() {
        return employeeService.transaction() > 1 ? "success" : "fail";
    }
}
