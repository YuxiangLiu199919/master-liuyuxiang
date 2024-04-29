package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    /**
     * 获取user
     *
     * @param
     * @return List<User>
     * @
     */
    public List<User> getUserList(@Param("userName") String userName);

    /**
     * 根据ID获取User
     *
     * @param
     * @return User
     * @
     */
    public User queryUserById(@Param("uid") int uid);

    /**
     * 添加User
     *
     * @param
     * @return int
     * @
     */
    public boolean addUser(@Param("userName")String userName,@Param("sex")int sex, @Param("userPhone")String userPhone,
                           @Param("userEmail")String userEmail,@Param("userPassword")String userPassword,
                        @Param("userAddress")String userAddress);
    /**
     * 修改User
     *
     * @param
     * @return int
     * @
     */
    public boolean modifyUser(@Param("uid") int uid,@Param("userName")String userName,@Param("sex")int sex,
                              @Param("userPhone")String userPhone,@Param("userEmail")String userEmail,
                          @Param("userPassword")String userPassword,
                          @Param("userAddress")String userAddress);
    /**
     * 删除User
     *
     * @param
     * @return boolean
     * @
     */
    public boolean deleteUserById(@Param("uid") int uid);

    /**
     * 批量删除User
     *
     * @param
     * @return boolean
     * @
     */
    public int delUserAllById(List<Integer> uid);

}
