package com.etc.springcloud.service;

import com.etc.springcloud.mapper.OrdersMapper;
import com.etc.springcloud.pojo.Orders;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;


    @Override
    public List<Orders> queryOrders(int uid) {
        return ordersMapper.queryOrders(uid);
    }

    @Override
    public int getOrdersId(String orderNum) {
        return ordersMapper.getOrdersId(orderNum);
    }

    @Override
    public String getOrderNum(int oid) {
        return ordersMapper.getOrderNum(oid);
    }

    @Override
    public boolean addOrder(int uid, int quantity, Double price_total,String orderNum) {
        return ordersMapper.addOrder(uid,quantity, price_total,orderNum);
    }

    @Override
    public boolean deleteOrder(int oid, int uid) {
        return ordersMapper.deleteOrder(oid, uid);
    }

    @Override
    public boolean updateOrder(int aid,int oid, int uid) {
        return ordersMapper.updateOrder(aid,oid, uid);
    }

    @Override
    public boolean updateOrderPay(String orderNum) {
        return ordersMapper.updateOrderPay(orderNum);
    }
}
