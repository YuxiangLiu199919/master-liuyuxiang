package com.etc.springcloud.service;

import com.etc.springcloud.mapper.CartMapper;
import com.etc.springcloud.pojo.Cart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Resource
    private CartMapper cartMapper;


    @Override
    public boolean addGoodsToCart(int gid, int uid) {
        return cartMapper.addGoodsToCart(gid, uid);
    }

    @Override
    public List<Cart> queryCart(int uid) {
        return cartMapper.queryCart(uid);
    }

    @Override
    public Cart queryCartTotalPrice(int uid) {
        return cartMapper.queryCartTotalPrice(uid);
    }

    @Override
    public Cart queryCartById(int gid, int uid) {
        return cartMapper.queryCartById(gid, uid);
    }

    @Override
    public boolean updataGoodsMquantity(int gid, int uid) {
        return cartMapper.updataGoodsMquantity(gid, uid);
    }

    @Override
    public boolean updataGoodsPquantity(int gid, int uid) {
        return cartMapper.updataGoodsPquantity(gid, uid);
    }


    @Override
    public boolean deleteGoodsCart(int gid,int uid) {
        return cartMapper.deleteGoodsCart(gid,uid);
    }

    @Override
    public boolean deleteCart(int uid) {
        return cartMapper.deleteCart(uid);
    }
}
