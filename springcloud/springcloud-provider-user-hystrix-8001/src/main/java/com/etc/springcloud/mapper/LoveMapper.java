package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Love;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LoveMapper {
    /**
     * 添加Love
     * @param
     * @return boolean
     * @
     */
     public boolean addLove(@Param("gid") int gid,@Param("uid") int uid);

    /**
     * 查找Love
     * @param
     * @return Love
     * @
     */
    public List<Love> queryLove(@Param("uid") int uid);

    /**
     * 查找Love
     * @param
     * @return Love
     * @
     */
    public int getLoveById(@Param("gid") int gid);

    /**
     * 删除Love
     * @param
     * @return boolean
     * @
     */
    public boolean deleteLove(@Param("gid") int gid);



}
