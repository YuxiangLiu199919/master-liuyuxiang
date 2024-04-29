package com.etc.springcloud.service;

import com.etc.springcloud.mapper.OdetailsMapper;
import com.etc.springcloud.mapper.OrderMapper;
import com.etc.springcloud.pojo.Odetails;
import com.etc.springcloud.pojo.Orders;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OdetailsServiceImpl implements OdetailsService{
    @Resource
    private OdetailsMapper odetailsMapper;

    @Override
    public List<Odetails> queryOdetails(int oid) {
        return odetailsMapper.queryOdetails(oid);
    }
}
