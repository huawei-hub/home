package com.hua.service.impl;

import com.hua.entity.Employee;
import com.hua.entity.Person;
import com.hua.mapper.fk.PersonMapper;
import com.hua.mapper.lk.EmployeeMapper;
import com.hua.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private PersonMapper personMapper;

    @Override
    public Employee findEmployee(Map<String, Object> map) {
        return employeeMapper.findEmployee(map);
    }

    //spring注解
    @Override
    @Transactional
    public int transaction() {
        Employee employee = new Employee();
        employee.setId(11);
        employee.setManageId(1);
        employee.setName("王语嫣");
        employee.setSalary(11000.00);
        int i = employeeMapper.insertEmployee(employee);
        int sum = 10 / 0;
        Person person = new Person();
        person.setId(7);
        person.setName("王语嫣");
        person.setPhone("10090");
        int j = personMapper.insertPerson(person);
        return Math.max(i+j, 0);
    }


}
