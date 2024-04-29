package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.Orders;
import com.etc.springcloud.pojo.User;
import com.etc.springcloud.service.OrderService;
import com.etc.springcloud.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/ordersList")
    @ResponseBody
    public String OrderList(String orderNum,String pageIndex){
        int pageSize= Constants.pageSize;
        int currentPageNo=1;
        if(pageIndex!=null&&pageIndex!="") {
            currentPageNo=Integer.valueOf(pageIndex);
        }else {
            currentPageNo=1;
        }
        PageInfo<Orders> pages =orderService.getOrderList(orderNum, currentPageNo, pageSize);
        Map<String, Object> map=new HashMap<String, Object>();

        map.put("pages", pages);
        return JSON.toJSONString(map);
    }



    //备选方案
    public User hystrixGet(@PathVariable("id") int id){
        return new User()
                .setUid(id)
                .setUserName("uid=>"+id+"没有对应的信息，null--@Hystrix")
                .setUserPhone("null")
                .setUserEmail("null")
                .setSex(0)
                .setUserPassword("null");
    }

}
