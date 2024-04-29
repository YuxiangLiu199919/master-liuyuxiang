package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.Odetails;
import com.etc.springcloud.service.OdetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//提供restful服务
@Controller
public class OdetailsController {

    @Resource
    private OdetailsService odetailsService;
    //查询用户订单详情
    @RequestMapping("/user/queryOdetails")
    @ResponseBody
    public String queryOdetails(int oid){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Odetails> odetailsList= odetailsService.queryOdetails(oid);
        map.put("odetailsList",odetailsList);
        return JSON.toJSONString(map);
    }

}
