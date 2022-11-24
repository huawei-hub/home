package com.hua.mapper.lk;

import com.hua.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface EmployeeMapper {
    Integer findCount();

    Employee findEmployee(Map<String, Object> map);

    int insertEmployee(Employee employee);
}
