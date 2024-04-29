package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Odetails;
import com.etc.springcloud.pojo.Orders;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface OdetailsService {


    /**
     * 查询订单详情
     * @param
     * @return List<Odetails>
     * @
     */
    public List<Odetails> queryOdetails( int oid);

}
