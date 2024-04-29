package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Admin;

import java.util.List;


public interface AdminService {


    /**
     * Admin登录
     * @param
     * @return admin
     * @
     */
    public Admin login(String adminCode, String adminPassword);


}
