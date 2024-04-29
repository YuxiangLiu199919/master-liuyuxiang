package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.User;
import com.etc.springcloud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//提供restful服务
@Controller
public class UserController {

    @Resource
    private UserService userService;


//    @GetMapping("/user/get/{id}")
//    @ResponseBody
//    @HystrixCommand(fallbackMethod = "hystrixGet")
//    public User get(@PathVariable("id") int id){
//        User user=userService.queryById(id);
//        if(user==null){
//            throw new RuntimeException("id=>"+id+",不存在这个用户");
//        }
//        return user;
//    }
    //登录
    @RequestMapping("/user/login")
    @ResponseBody
    public String userLogin(String userEmail, String userPassword, HttpSession session, HttpServletRequest request){
        User user=userService.userLogin(userEmail,userPassword);
        Map<String,String> map=new HashMap<String,String>();
        if(user!=null){
            //生成一个登录凭证
//            String token= UUID.randomUUID().toString().replace("-","").toLowerCase();
            String token=user.getUid().toString();
//            session.getServletContext().setAttribute(token,user);
            map.put("token",token);
            map.put("loginFlag","true");
            return JSON.toJSONString(map);
        }else{
            map.put("loginFlag","false");
            return JSON.toJSONString(map);
        }

    }
    //注册
    @RequestMapping("/user/signUp")
    @ResponseBody
    public String userSignUp(String userName, String userPhone, String userEmail, String userPassword){
        Map<String,String> map=new HashMap<String,String>();
        boolean result=userService.userSignUp(userName, userPhone, userEmail, userPassword);
        if(result){
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return JSON.toJSONString(map);
    }


    //备选方案
//    public User hystrixGet(@PathVariable("id") int id){
//        return new User()
//                .setUid(id)
//                .setUserName("uid=>"+id+"没有对应的信息，null--@Hystrix")
//                .setUserPhone("null")
//                .setUserEmail("null")
//                .setSex(0)
//                .setUserPassword("null");
//    }
}
