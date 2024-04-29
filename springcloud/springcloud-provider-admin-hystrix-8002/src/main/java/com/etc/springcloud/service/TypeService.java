package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Type;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TypeService {
    /**
     * 获取goodType
     * @param
     * @return Type
     * @
     */
    public PageInfo<Type> getTypeList(String type_name, int currentPageNo, int pageSize);
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
     * @param
     * @return Type
     * @
     */
    public Type queryTypeById(int tid);
    /**
     * 修改Type_name
     * @param
     * @return boolean
     * @
     */
    public boolean modifyType(int tid,String type_name);

    /**
     * 添加Type_name
     * @param
     * @return boolean
     * @
     */
    public int addType(String type_name);

    /**
     * 删除Type
     * @param
     * @return boolean
     * @
     */
    public int deleteType( int tid);

    /**
     * 批量删除Type
     *
     * @param
     * @return boolean
     * @
     */
    public int delTypeAllById(List<Integer> tid);

}
