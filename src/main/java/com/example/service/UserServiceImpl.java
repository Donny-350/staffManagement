package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectPasswordByName(String userName, String password) {
        return userMapper.selectPasswordByName(userName, password);
    }
}
