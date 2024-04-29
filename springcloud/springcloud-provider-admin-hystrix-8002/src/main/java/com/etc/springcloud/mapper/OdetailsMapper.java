package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Odetails;
import com.etc.springcloud.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OdetailsMapper {


    /**
     * 查询订单详情
     * @param
     * @return List<Odetails>
     * @
     */
    public List<Odetails> queryOdetails(@Param("oid") int oid);



}
