package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AddressMapper {
    /**
     * 添加Address
     * @param
     * @return boolean
     * @
     */
     public boolean addAddress(@Param("uid") int uid,@Param("receiver_name") String receiver_name
     ,@Param("receiver_address") String receiver_address,@Param("receiver_phone") String receiver_phone);

    /**
     * 更新Address
     * @param
     * @return boolean
     * @
     */
    public boolean updateAddress(@Param("uid") int uid,@Param("receiver_name") String receiver_name
            ,@Param("receiver_address") String receiver_address,@Param("receiver_phone") String receiver_phone);
    /**
     * 查询Address
     * @param
     * @return Address
     * @
     */
    public Address queryAddress(@Param("uid") int uid);

}
