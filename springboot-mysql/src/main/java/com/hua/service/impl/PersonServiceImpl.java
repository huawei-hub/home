package com.hua.service.impl;

import com.hua.mapper.PersonMapper;
import com.hua.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public int findCount() {
//        return personMapper.findCount();
        return 0;
    }
}
