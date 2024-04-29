package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Odetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Mapper
public interface OdetailsMapper {
    /**
     * 添加Order
     * @param
     * @return boolean
     * @
     */
     public boolean addOdetails(@Param("doid") int doid,
                             @Param("dName") String dName,
                             @Param("dPrice") BigDecimal dPrice,
                             @Param("dnum") int dnum);

    /**
     * 查询订单详情
     * @param
     * @return List<Odetails>
     * @
     */
    public List<Odetails> queryOdetails(@Param("oid") int oid);


}
