package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Goods;

import java.util.List;


public interface GoodsService {


    /**
     * 获取Goods
     * @param
     * @return List<Goods>
     * @
     */
    public List<Goods> queryGoods();
    /**
     * 模糊查询Goods
     *
     * @param
     * @return List<Goods>
     * @
     */
    public List<Goods> queryGoodsByName( String name);
    /**
     * 获取Goods
     * @param
     * @return List<Goods>
     * @
     */
    public List<Goods> querySpecialGoods();

    /**
     * 根据ID获取Goods
     * @param
     * @return Goods
     * @
     */
    public Goods getGoodsById( int gid);

    /**
     * 根据ID获取List<Goods>
     * @param
     * @return List<Goods>
     * @
     */
    public List<Goods> queryGoodsByTypeId(int tid);

    /**
     * 根据gid更新商品库存量
     * @param
     * @return Boolean
     * @
     */
    public Boolean upGoodsStocks( int gid,int num);

}
