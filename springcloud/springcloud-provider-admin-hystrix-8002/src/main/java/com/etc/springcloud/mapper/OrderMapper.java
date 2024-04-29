package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {
    /**
     * 获取Order
     *
     * @param
     * @return List<Order>
     * @
     */
    public List<Orders> getOrderList(@Param("orderNum") String orderNum);


    /**
     * 获取Order
     *
     * @param
     * @return Order
     * @
     */
    public Orders getOrderById(@Param("oid") int oid);



}
