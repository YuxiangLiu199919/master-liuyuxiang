package com.etc.springcloud.service;

import com.etc.springcloud.mapper.OrderMapper;
import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.Odetails;
import com.etc.springcloud.pojo.Orders;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Resource
    private OrderMapper orderMapper;
    @Override
    public PageInfo<Orders> getOrderList(String orderNum, int currentPageNo, int pageSize) {
        PageHelper.startPage(currentPageNo,pageSize);
        List<Orders>list=orderMapper.getOrderList(orderNum);
        PageInfo<Orders> pageInfo=new PageInfo<Orders>(list);
        return pageInfo;
    }

    @Override
    public Orders getOrderById(int oid) {
        return orderMapper.getOrderById(oid);
    }
}
