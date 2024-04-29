package com.etc.order.repository.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.etc.order.repository.dao.OrderDao;
import com.etc.order.repository.entity.MasterOrder;
import com.etc.order.repository.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Resource
    private OrderMapper orderMapper;


    @Override
    public List<MasterOrder> queryOrder() {

        return orderMapper.queryOrder();
    }

    @Override
    public Integer createOrder(MasterOrder masterOrder) {
        return orderMapper.createOrder(masterOrder);
    }

    @Override
    public Integer updateMasterOrder(String statusCd,String orderId) {
        if(StringUtils.isEmpty(statusCd) || StringUtils.isEmpty(orderId) ){
            return 0;
        }
        return orderMapper.updateMasterOrder(statusCd,orderId);
    }
}
