package com.etc.springcloud.service;

import com.etc.springcloud.mapper.TypeMapper;
import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.Type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{
    @Resource
    private TypeMapper typeMapper;


    @Override
    public List<Type> queryType() {
        return typeMapper.queryType();
    }

    @Override
    public List<Goods> querySpecialGoods() {
        return null;
    }

    @Override
    public Goods getGoodsById(int gid) {
        return null;
    }
}
