package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Love;

import java.util.List;

public interface LoveService {
    /**
     * 添加Love
     * @param
     * @return boolean
     * @
     */
    public boolean addLove(int gid,int uid);

    /**
     * 查找Love
     * @param
     * @return Love
     * @
     */
    public List<Love> queryLove(int uid);
    /**
     * 查找Love
     * @param
     * @return Love
     * @
     */
    public int getLoveById(int gid);

    /**
     * 删除Love
     * @param
     * @return boolean
     * @
     */
    public boolean deleteLove(int gid);

}
