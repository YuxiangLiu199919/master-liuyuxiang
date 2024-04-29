package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Admin;
import com.etc.springcloud.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminMapper {

    /**
     * Admin登录
     * @param
     * @return admin
     * @
     */
    public Admin login(@Param("adminCode")String adminCode, @Param("adminPassword") String adminPassword);
}
