package com.etc.springcloud.service;

import com.etc.springcloud.mapper.UserMapper;
import com.etc.springcloud.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;


    @Override
    public boolean addUser(String userName,int sex, String userPhone,String userEmail,String userPassword,  String userAddress) {
        return userMapper.addUser(userName,sex,userPhone, userEmail,userPassword,userAddress);
    }

    @Override
    public PageInfo<User> getUserList(String userName, int currentPageNo, int pageSize) {
        PageHelper.startPage(currentPageNo,pageSize);
        List<User>list=userMapper.getUserList(userName);
        PageInfo<User> pageInfo=new PageInfo<User>(list);
        return pageInfo;
    }


    @Override
    public User queryUserById(int uid) {
        return userMapper.queryUserById(uid);
    }

    @Override
    public boolean modifyUser(int uid, String userName,int sex, String userPhone,String userEmail,  String userPassword,  String userAddress) {
        return userMapper.modifyUser(uid, userName, sex, userPhone, userEmail, userPassword, userAddress);
    }

    @Override
    public boolean deleteUserById(int uid) {
        return userMapper.deleteUserById(uid);
    }

    @Override
    public int delUserAllById(List<Integer> uid) {
        return 0;
    }
}
