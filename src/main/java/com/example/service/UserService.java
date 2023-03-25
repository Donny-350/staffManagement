package com.example.service;

import com.example.pojo.User;

public interface UserService {

    User selectPasswordByName(String userName, String password);
}
