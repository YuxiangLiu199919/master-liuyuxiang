package com.etc.springcloud.service;

import com.etc.springcloud.mapper.UserMapper;
import com.etc.springcloud.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;


    @Override
    public User queryById(int uid) {
        return null;
    }

    @Override
    public User userLogin(String userEmail, String userPassword) {
        return userMapper.userLogin(userEmail,userPassword);
    }

    @Override
    public boolean userSignUp(String userName, String userPhone, String userEmail, String userPassword) {
        return userMapper.userSignUp(userName, userPhone, userEmail, userPassword);
    }
}
