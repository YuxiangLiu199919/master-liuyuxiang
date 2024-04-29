package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Orders;

import java.util.List;

public interface OrdersService {

    /**
     * 查询Orders
     * @param
     * @return List<Orders>
     * @
     */
    public List<Orders> queryOrders( int uid);
    /**
     * 查询OrderId
     * @param
     * @return boolean
     * @
     */
    public int  getOrdersId(String orderNum);
    /**
     * 查询OrderNum
     * @param
     * @return boolean
     * @
     */
    public String  getOrderNum( int oid);

    /**
     * 添加Order
     * @param
     * @return boolean
     * @
     */
    public boolean addOrder(int uid,int quantity,Double price_total,String orderNum);

    /**
     * 取消Order
     * @param
     * @return boolean
     * @
     */
    public boolean deleteOrder( int oid, int uid);

    /**
     * 更新Order
     * @param
     * @return boolean
     * @
     */
    public boolean updateOrder(int aid, int oid, int uid);

    /**
     * 更新OrderPay
     * @param
     * @return boolean
     * @
     */
    public boolean updateOrderPay( String orderNum);
}
