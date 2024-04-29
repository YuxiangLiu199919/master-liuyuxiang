package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.Type;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface GoodsService {
    /**
     * 获取goodType
     * @param
     * @return Type
     * @
     */
    public PageInfo<Goods> getGoodsList(String name, int currentPageNo, int pageSize);

    /**
     * 根据ID获取Type
     * @param
     * @return Type
     * @
     */
    public Goods queryGoodsById(int gid);

    /**
     * 添加goods
     * @param
     * @return int
     * @
     */
    public int addGoods(String name, int tid,Double price, Double discount,int stock, String details, String image);
    /**
     * 修改goods
     * @param
     * @return int
     * @
     */
    public int modifyGoods(int gid,String name, int tid,Double price,Double discount, int stock, String details, String image);

    /**
     * 删除Goods
     * @param
     * @return int
     * @
     */
    public int deleteGoods( int gid);

    /**
     * 批量删除Type
     *
     * @param
     * @return boolean
     * @
     */
    public int delTypeAllById(List<Integer> tid);

}
