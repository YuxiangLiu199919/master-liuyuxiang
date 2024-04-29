package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.Admin;
import com.etc.springcloud.pojo.User;
import com.etc.springcloud.service.AdminService;
import com.etc.springcloud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//提供restful服务
@Controller
public class AdminController {

    @Resource
    private UserService userService;

    @Resource
    private AdminService adminService;

//    @GetMapping("/user/get/{id}")
//    @ResponseBody
//    @HystrixCommand(fallbackMethod = "hystrixGet")
//    public User get(@PathVariable("id") int id){
//        User user=userService.queryById(id);
////        System.out.println(user.toString());
//        if(user==null){
//            throw new RuntimeException("id=>"+id+",不存在这个用户");
//        }
//        return user;
//    }
//管理员登录
    @RequestMapping("/admin/login")
    @ResponseBody
    public String login(String adminCode, String adminPassword, HttpSession session, HttpServletRequest request){
        Admin admin=adminService.login(adminCode,adminPassword);
        Map<String,String> map=new HashMap<String,String>();
        if(admin!=null){
            //生成一个登录凭证
            String token= UUID.randomUUID().toString().replace("-","").toLowerCase();
//            session.getServletContext().setAttribute(token,admin);
            map.put("token",token);
            map.put("loginFlag","true");
        }else{
            map.put("loginFlag","false");
        }
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
