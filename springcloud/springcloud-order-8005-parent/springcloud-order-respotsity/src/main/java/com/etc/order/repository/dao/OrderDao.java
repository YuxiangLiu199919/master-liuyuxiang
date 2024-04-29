package com.etc.order.repository.dao;

import com.etc.order.repository.entity.MasterOrder;

import java.util.List;

public interface OrderDao {

    List<MasterOrder> queryOrder();

    Integer createOrder(MasterOrder masterOrder);

    Integer updateMasterOrder(String statusCd,String orderId);
}
