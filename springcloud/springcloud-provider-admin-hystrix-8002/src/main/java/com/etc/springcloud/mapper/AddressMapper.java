package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AddressMapper {

    /**
     * 查询Address
     * @param
     * @return Address
     * @
     */
    public Address queryAddress(@Param("uid") int uid);




}
