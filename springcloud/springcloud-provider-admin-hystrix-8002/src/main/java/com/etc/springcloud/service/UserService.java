package com.etc.springcloud.service;

import com.etc.springcloud.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface UserService {
    /**
     * 增加用户信息
     * @paramuser
     * @return
     * @
     */
    public boolean addUser(String userName, int sex,
                           String userPhone,String userEmail, String userPassword,
                            String userAddress);

    /**
     * 获取user
     *
     * @param
     * @return List<User>
     * @
     */
    public PageInfo<User> getUserList(String userName, int currentPageNo, int pageSize);
    /**
     * 根据ID获取User
     *
     * @param
     * @return User
     * @
     */
    public User queryUserById(int uid);

    /**
     * 修改User
     *
     * @param
     * @return int
     * @
     */
    public boolean modifyUser(int uid,String userName,int sex,String userPhone,String userEmail,
                          String userPassword,
                          String userAddress);
    /**
     * 删除User
     *
     * @param
     * @return boolean
     * @
     */
    public boolean deleteUserById(int uid);

    /**
     * 批量删除User
     *
     * @param
     * @return boolean
     * @
     */
    public int delUserAllById(List<Integer> uid);
    /**
     * User登录
     * @param
     * @return user
     * @
     */
//    public User login(String userEmail,String userPassword);
}
