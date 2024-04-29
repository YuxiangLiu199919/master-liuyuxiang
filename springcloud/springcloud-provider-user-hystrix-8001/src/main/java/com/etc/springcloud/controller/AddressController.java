package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.Address;
import com.etc.springcloud.service.AddressService;
import com.etc.springcloud.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

//提供restful服务
@RestController
public class AddressController {

    @Resource
    private AddressService addressService;
    @Resource
    private OrdersService ordersService;

//    新增地址
    @RequestMapping("/user/addAddress")
    @ResponseBody
    public String useraddAddress(int uid,int oid, String receiver_name, String receiver_address, String receiver_phone){
        Map<String,Object> map=new HashMap<String,Object>();
        Address address=addressService.queryAddress(uid);
        if(address==null){
            Boolean result=addressService.addAddress(uid, receiver_name, receiver_address, receiver_phone);
//           地址增加成功后更新订单地址ID
            if(result){
                Address address1=addressService.queryAddress(uid);
                int aid=address1.getAid();
                if(ordersService.updateOrder(aid,oid,uid)){
                    map.put("flag","true");
                }else{
                    map.put("flag","false");
                }
            }else{
                map.put("flag","false");
            }
        }else{
            Boolean result=addressService.updateAddress(uid, receiver_name, receiver_address, receiver_phone);
            if(result){
                Address address1=addressService.queryAddress(uid);
                int aid=address1.getAid();
//                地址存在则更新Order的地址ID
                if(ordersService.updateOrder(aid,oid,uid)){
                    map.put("flag","true");
                }else{
                    map.put("flag","false");
                }
            }else{
                map.put("flag","false");
            }
        }


        return JSON.toJSONString(map);

    }


}
