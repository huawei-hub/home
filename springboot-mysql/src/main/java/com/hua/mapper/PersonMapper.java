package com.hua.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
    int find(Long id);
}
