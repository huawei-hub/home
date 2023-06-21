package com.hua.service;

import com.hua.jwt.entity.User;
import com.hua.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User find(Long id) {
        return userMapper.findById(id);
    }

}
