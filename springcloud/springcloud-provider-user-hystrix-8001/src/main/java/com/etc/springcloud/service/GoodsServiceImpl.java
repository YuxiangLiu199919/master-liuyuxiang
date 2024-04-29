package com.etc.springcloud.service;

import com.etc.springcloud.mapper.GoodsMapper;
import com.etc.springcloud.mapper.UserMapper;
import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Resource
    private GoodsMapper goodsMapper;


    @Override
    public List<Goods> queryGoods() {
        return goodsMapper.queryGoods();
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        return goodsMapper.queryGoodsByName(name);
    }

    @Override
    public List<Goods> querySpecialGoods() {
        return goodsMapper.querySpecialGoods();
    }

    @Override
    public Goods getGoodsById(int gid) {
        return goodsMapper.getGoodsById(gid);
    }

    @Override
    public List<Goods> queryGoodsByTypeId(int tid) {
        return goodsMapper.queryGoodsByTypeId(tid);
    }

    @Override
    public Boolean upGoodsStocks(int gid, int num) {
        return goodsMapper.upGoodsStocks(gid, num);
    }
}
