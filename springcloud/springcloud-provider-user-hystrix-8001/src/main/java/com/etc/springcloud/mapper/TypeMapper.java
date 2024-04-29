package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TypeMapper {

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
    public Goods getGoodsById(@Param("gid") int gid);



}
