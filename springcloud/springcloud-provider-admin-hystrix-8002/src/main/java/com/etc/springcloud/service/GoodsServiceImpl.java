package com.etc.springcloud.service;

import com.etc.springcloud.mapper.GoodsMapper;
import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.Type;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Resource
    private GoodsMapper goodsMapper;
    @Override
    public PageInfo<Goods> getGoodsList(String name, int currentPageNo, int pageSize) {
        PageHelper.startPage(currentPageNo,pageSize);
        List<Goods>list=goodsMapper.getGoodsList(name);
        PageInfo<Goods> pageInfo=new PageInfo<Goods>(list);
        return pageInfo;
    }

    @Override
    public Goods queryGoodsById(int gid) {
        return goodsMapper.queryGoodsById(gid);
    }



    @Override
    public int addGoods(String name, int tid, Double price, Double discount,int stock, String details, String image) {
        return goodsMapper.addGoods(name, tid, price,discount,stock, details, image);
    }

    @Override
    public int modifyGoods(int gid,String name, int tid, Double price,Double discount, int stock, String details, String image) {
        return goodsMapper.modifyGoods(gid,name, tid, price,discount, stock, details, image);
    }


    @Override
    public int deleteGoods(int gid) {
        return goodsMapper.deleteGoods(gid);
    }

    @Override
    public int delTypeAllById(List<Integer> tid) {
        return 0;
    }


}
