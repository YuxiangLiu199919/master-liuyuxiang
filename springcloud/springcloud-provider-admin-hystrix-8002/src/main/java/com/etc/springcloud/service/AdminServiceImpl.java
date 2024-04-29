package com.etc.springcloud.service;

import com.etc.springcloud.mapper.AdminMapper;
import com.etc.springcloud.pojo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminMapper adminMapper;



    @Override
    public Admin login(String adminCode, String adminPassword) {
        return adminMapper.login(adminCode,adminPassword);
    }
}
