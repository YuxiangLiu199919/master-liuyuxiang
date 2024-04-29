package com.etc.springcloud.mapper;

import com.etc.springcloud.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface TypeMapper {
    /**
     * 获取goodType
     *
     * @param
     * @return Type
     * @
     */
    public List<Type> getTypeList(@Param("type_name") String type_name);

    /**
     * 获取goodType
     *
     * @param
     * @return Type
     * @
     */
    public List<Type> queryTypeList();

    /**
     * 根据ID获取Type
     *
     * @param
     * @return Type
     * @
     */
    public Type queryTypeById(@Param("tid") int tid);

    /**
     * 修改Type_name
     *
     * @param
     * @return boolean
     * @
     */
    public boolean modifyType(@Param("tid") int tid, @Param("type_name") String type_name);


    /**
     * 添加Type_name
     *
     * @param
     * @return boolean
     * @
     */
    public int addType(@Param("type_name") String type_name);

    /**
     * 删除Type
     *
     * @param
     * @return boolean
     * @
     */
    public int deleteType(@Param("tid") int tid);

    /**
     * 批量删除Type
     *
     * @param
     * @return boolean
     * @
     */
    public int delTypeAllById(List<Integer> tid);

}
