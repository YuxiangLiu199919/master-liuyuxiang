package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsMapper {


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
    public List<Goods> queryGoodsByName(@Param("name") String name);
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
    public Goods getGoodsById(@Param("gid") int gid);

    /**
     * 根据ID获取List<Goods>
     * @param
     * @return List<Goods>
     * @
     */
    public List<Goods> queryGoodsByTypeId(@Param("tid") int tid);

    /**
     * 根据gid更新商品库存量
     * @param
     * @return Boolean
     * @
     */
    public Boolean upGoodsStocks(@Param("gid") int gid,@Param("num") int num);


}
