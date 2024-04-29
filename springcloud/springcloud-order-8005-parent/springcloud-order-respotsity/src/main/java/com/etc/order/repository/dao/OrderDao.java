package com.etc.order.repository.dao;

import com.etc.order.repository.entity.MasterOrder;

import java.util.List;

public interface OrderDao {

    List<MasterOrder> queryOrderBySku(String skuId);

    MasterOrder queryByOrderId(String orderId,String buyerId,String orderStatus);

    Integer createOrder(MasterOrder masterOrder);

    Integer updateMasterOrder(String statusCd,String orderId);
}
