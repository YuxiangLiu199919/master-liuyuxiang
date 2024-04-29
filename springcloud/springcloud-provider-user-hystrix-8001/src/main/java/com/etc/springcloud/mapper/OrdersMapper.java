package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrdersMapper {

    /**
     * 查询Orders
     * @param
     * @return List<Orders>
     * @
     */
    public List<Orders> queryOrders(@Param("uid") int uid);
    /**
     * 查询OrderId
     * @param
     * @return boolean
     * @
     */
    public int  getOrdersId( @Param("orderNum") String orderNum);
    /**
     * 查询OrderNum
     * @param
     * @return boolean
     * @
     */
    public String  getOrderNum( @Param("oid") int oid);

    /**
     * 添加Order
     * @param
     * @return boolean
     * @
     */
     public boolean addOrder(@Param("uid") int uid,
                             @Param("quantity") int quantity,
                             @Param("price_total") Double price_total,
                             @Param("orderNum") String orderNum);

    /**
     * 取消Order
     * @param
     * @return boolean
     * @
     */
    public boolean deleteOrder(@Param("oid") int oid,@Param("uid") int uid);

    /**
     * 更新Order
     * @param
     * @return boolean
     * @
     */
    public boolean updateOrder(@Param("aid") int aid,@Param("oid") int oid,@Param("uid") int uid);

    /**
     * 更新Order
     * @param
     * @return boolean
     * @
     */
    public boolean updateOrderPay(@Param("orderNum") String orderNum);


}
