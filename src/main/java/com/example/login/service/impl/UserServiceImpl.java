package com.example.login.service.impl;

import com.example.login.mapper.UserMapper;
import com.example.login.proj.User;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean login(String username, String password) {
        User user = userMapper.getUserByUsernameAndPassword(username, password);
        if(user != null){
            System.out.println("Login Successful");
            return true;
        }else{
            System.out.println("login False");
            return false;
        }
    }
}
