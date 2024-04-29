package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.Odetails;
import com.etc.springcloud.pojo.Orders;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrderService {
    /**
     * 获取goodType
     * @param
     * @return Type
     * @
     */
    public PageInfo<Orders> getOrderList(String orderNum, int currentPageNo, int pageSize);


    /**
     * 获取Order
     *
     * @param
     * @return Order
     * @
     */
    public Orders getOrderById( int oid);

}
