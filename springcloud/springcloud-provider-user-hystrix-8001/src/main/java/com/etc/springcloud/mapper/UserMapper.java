package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    /**
     * 通过uid获取User
     * @param uid
     * @return user
     * @
     */
     public User queryById(int uid);

    /**
     * user登录
     * @param
     * @return user
     * @
     */
    public User userLogin(@Param("userEmail")String userEmail, @Param("userPassword") String userPassword);

    /**
     * 注册user
     * @param
     * @return user
     * @
     */
    public boolean userSignUp(@Param("userName") String userName,@Param("userPhone") String userPhone,
                          @Param("userEmail")String userEmail, @Param("userPassword") String userPassword);


}
