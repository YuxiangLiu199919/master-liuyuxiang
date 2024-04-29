package com.etc.springcloud.service;

import com.etc.springcloud.pojo.User;


public interface UserService {

    /**
     * 通过uid获取User
     * @param uid
     * @return user
     * @
     */
     public User queryById(int uid);

    /**
     * User登录
     * @param
     * @return user
     * @
     */
    public User userLogin(String userEmail,String userPassword);

    /**
     * 注册user
     * @param
     * @return user
     * @
     */
    public boolean userSignUp( String userName,String userPhone,
                           String userEmail, String userPassword);
}
