package com.etc.springcloud.service;

import com.etc.springcloud.mapper.TypeMapper;
import com.etc.springcloud.mapper.UserMapper;
import com.etc.springcloud.pojo.Type;
import com.etc.springcloud.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{
    @Resource
    private TypeMapper typeMapper;
    @Override
    public PageInfo<Type> getTypeList(String type_name, int currentPageNo, int pageSize) {
        PageHelper.startPage(currentPageNo,pageSize);
        List<Type>list=typeMapper.getTypeList(type_name);
        PageInfo<Type> pageInfo=new PageInfo<Type>(list);
        return pageInfo;
    }

    @Override
    public List<Type> queryTypeList() {
        return typeMapper.queryTypeList();
    }

    @Override
    public Type queryTypeById(int tid) {
        return typeMapper.queryTypeById(tid);
    }

    @Override
    public boolean modifyType(int tid,String type_name) {
        return typeMapper.modifyType(tid,type_name);
    }

    @Override
    public int addType(String type_name) {
        return typeMapper.addType(type_name);
    }

    @Override
    public int deleteType(int tid) {
        return typeMapper.deleteType(tid);
    }

    @Override
    public int delTypeAllById(List<Integer> tid) {
        return typeMapper.delTypeAllById(tid);
    }


}
