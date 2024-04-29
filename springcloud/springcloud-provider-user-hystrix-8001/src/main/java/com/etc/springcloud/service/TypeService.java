package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.Type;

import java.util.List;


public interface TypeService {


    /**
     * 获取Type
     * @param
     * @return List<Type>
     * @
     */
    public List<Type> queryType();
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

}
