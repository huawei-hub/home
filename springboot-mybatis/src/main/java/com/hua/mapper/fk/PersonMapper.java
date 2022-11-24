package com.hua.mapper.fk;

import com.hua.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PersonMapper {
    Person findById(@Param("id") Integer id);

    int insertPerson(Person person);
}
