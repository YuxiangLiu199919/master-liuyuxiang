package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CartService {
    /**
     * 添加Love
     * @param
     * @return boolean
     * @
     */
    public boolean addGoodsToCart( int gid, int uid);

    /**
     * 查找Love
     * @param
     * @return Love
     * @
     */
    public List<Cart> queryCart( int uid);


    /**
     * 查寻Cart总价
     * @param
     * @return Cart
     * @
     */
    public Cart queryCartTotalPrice( int uid);
    /**
     * 通过IDs查找Cart
     * @param
     * @return Cart
     * @
     */
    public Cart queryCartById( int gid, int uid);
    /**
     * 减少Cart数量
     * @param
     * @return boolean
     * @
     */
    public boolean updataGoodsMquantity(int gid, int uid);

    /**
     * 增加Cart数量
     * @param
     * @return boolean
     * @
     */
    public boolean updataGoodsPquantity(int gid, int uid);

    /**
     * 删除Love
     * @param
     * @return boolean
     * @
     */
    public boolean deleteGoodsCart(int gid,int uid);


    /**
     * 删除Cart
     * @param
     * @return boolean
     * @
     */
    public boolean deleteCart(@Param("uid") int uid);
}
