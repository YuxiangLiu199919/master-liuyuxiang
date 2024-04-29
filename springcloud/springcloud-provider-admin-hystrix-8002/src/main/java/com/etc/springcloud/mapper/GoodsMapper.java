package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsMapper {
    /**
     * 获取goodType
     *
     * @param
     * @return Type
     * @
     */
    public List<Goods> getGoodsList(@Param("name") String name);

    /**
     * 根据ID获取Type
     *
     * @param
     * @return Type
     * @
     */
    public Goods queryGoodsById(@Param("gid") int gid);

    /**
     * 修改Type_name
     *
     * @param
     * @return boolean
     * @
     */
    public boolean modifyType(@Param("tid") int tid, @Param("type_name") String type_name);


    /**
     * 添加goods
     *
     * @param
     * @return int
     * @
     */
    public int addGoods(@Param("name")String name,@Param("type_id")int tid,
                        @Param("price")Double price,@Param("discount")Double discount,@Param("stock")int stock,
                        @Param("details")String details,@Param("image")String image);
    /**
     * 修改goods
     *
     * @param
     * @return int
     * @
     */
    public int modifyGoods(@Param("gid")int gid,@Param("name")String name,@Param("type_id")int tid,
                        @Param("price")Double price,@Param("discount")Double discount,@Param("stock")int stock,
                        @Param("details")String details,@Param("image")String image);
    /**
     * 删除Goods
     *
     * @param
     * @return boolean
     * @
     */
    public int deleteGoods(@Param("gid") int gid);

    /**
     * 批量删除Type
     *
     * @param
     * @return boolean
     * @
     */
    public int delTypeAllById(List<Integer> tid);

}
