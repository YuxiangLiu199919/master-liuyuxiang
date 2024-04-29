package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Odetails;

import java.math.BigDecimal;
import java.util.List;

public interface OdetailsService {


    /**
     * 添加Order
     * @param
     * @return boolean
     * @
     */
    public boolean addOdetails(int doid, String dName, BigDecimal dPrice, int dnum);

    /**
     * 取消Order
     * @param
     * @return boolean
     * @
     */
    public List<Odetails> queryOdetails(int oid);
}
