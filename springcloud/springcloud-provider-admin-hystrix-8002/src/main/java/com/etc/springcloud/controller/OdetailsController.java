package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.Address;
import com.etc.springcloud.pojo.Odetails;
import com.etc.springcloud.pojo.Orders;
import com.etc.springcloud.service.AddressService;
import com.etc.springcloud.service.OdetailsService;
import com.etc.springcloud.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OdetailsController {

    @Resource
    private OdetailsService odetailsService;
    @Resource
    private OrderService orderService;
    @Resource
    private AddressService addressService;
//查询商品详情
    @RequestMapping("/queryOdetails")
    @ResponseBody
    public String queryOdetails(int oid){
        Map<String, Object> map=new HashMap<String, Object>();
        List<Odetails> odetailsList=odetailsService.queryOdetails(oid);
        Orders orders=orderService.getOrderById(oid);
        int uid=orders.getUser_id();
        Address address=addressService.queryAddress(uid);
        map.put("odetailsList", odetailsList);
        map.put("orders", orders);
        map.put("address", address);
        return JSON.toJSONString(map);
    }

}
