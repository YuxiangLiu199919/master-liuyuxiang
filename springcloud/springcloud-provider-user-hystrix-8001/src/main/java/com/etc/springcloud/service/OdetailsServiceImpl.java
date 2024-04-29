package com.etc.springcloud.service;

import com.etc.springcloud.mapper.OdetailsMapper;
import com.etc.springcloud.mapper.OrdersMapper;
import com.etc.springcloud.pojo.Odetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OdetailsServiceImpl implements OdetailsService {
    @Resource
    private OdetailsMapper odetailsMapper;


    @Override
    public boolean addOdetails(int doid, String dName, BigDecimal dPrice, int dnum) {
        return odetailsMapper.addOdetails(doid, dName, dPrice, dnum);
    }



    @Override
    public List<Odetails> queryOdetails(int oid) {
        return odetailsMapper.queryOdetails(oid);
    }
}
