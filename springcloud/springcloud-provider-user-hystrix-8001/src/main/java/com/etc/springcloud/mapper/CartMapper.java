package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartMapper {
    /**
     * 添加Cart
     * @param
     * @return boolean
     * @
     */
     public boolean addGoodsToCart(@Param("gid") int gid,@Param("uid") int uid);

    /**
     * 查找Cart
     * @param
     * @return List<Cart>
     * @
     */
    public List<Cart> queryCart(@Param("uid") int uid);

    /**
     * 查寻Cart总价
     * @param
     * @return Cart
     * @
     */
    public Cart queryCartTotalPrice(@Param("uid") int uid);

    /**
     * 通过IDs查找Cart
     * @param
     * @return Cart
     * @
     */
    public Cart queryCartById(@Param("gid") int gid,@Param("uid") int uid);

    /**
     * 减少Cart数量
     * @param
     * @return boolean
     * @
     */
    public boolean updataGoodsMquantity(@Param("gid") int gid,@Param("uid") int uid);
    /**
     * 增加Cart数量
     * @param
     * @return boolean
     * @
     */
    public boolean updataGoodsPquantity(@Param("gid") int gid,@Param("uid") int uid);

    /**
     * 删除Cart
     * @param
     * @return boolean
     * @
     */
    public boolean deleteGoodsCart(@Param("gid") int gid,@Param("uid") int uid);

    /**
     * 删除Cart
     * @param
     * @return boolean
     * @
     */
    public boolean deleteCart(@Param("uid") int uid);



}
