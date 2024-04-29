package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.User;
import com.etc.springcloud.service.UserService;
import com.etc.springcloud.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
////        System.out.println(user.toString());
//        if(user==null){
//            throw new RuntimeException("id=>"+id+",不存在这个用户");
//        }
//        return user;
//    }
//查询用户
    @RequestMapping("/userList")
    @ResponseBody
    public String UserList(String userName,String pageIndex){
        int pageSize= Constants.pageSize;
        int currentPageNo=1;
        if(pageIndex!=null&&pageIndex!="") {
            currentPageNo=Integer.valueOf(pageIndex);
        }else {
            currentPageNo=1;
        }
        PageInfo<User> pages =userService.getUserList(userName, currentPageNo, pageSize);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("pages", pages);
        return JSON.toJSONString(map);
    }
//    新增用户
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(String userName,String userSex,String userPhone,String userEmail,String userPassword,String userAddress){
        Map<String,Object> map=new HashMap<String,Object>();
        int sex=Integer.valueOf(userSex);
        if (userService.addUser(userName,sex,userPhone,userEmail,userPassword,userAddress)){
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return JSON.toJSONString(map);
    }
//    根据UserID查询用户
    @RequestMapping("/queryUserById")
    @ResponseBody
    public String queryUserById(int uid ){
        Map<String, Object> map=new HashMap<String, Object>();
        User user=userService.queryUserById(uid);
        if(user!=null){
            map.put("user",user);

        }else{
            map.put("flag","false");
        }
        return JSON.toJSONString(map);
    }
//    修改用户
    @RequestMapping("/modifyUser")
    @ResponseBody
    public String modifyUser(int uid,String userName,int sex,String userPhone,String userEmail,String userPassword,String userAddress){
        Map<String,Object> map=new HashMap<String,Object>();
        if (userService.modifyUser(uid,userName,sex,userPhone,userEmail,userPassword,userAddress)){
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return JSON.toJSONString(map);
    }
//根据用户ID删除用户
    @RequestMapping("/deleteUserById")
    @ResponseBody
    public String deleteUserById(int uid){
        Map<String,Object> map=new HashMap<String,Object>();
        if (userService.deleteUserById(uid)){
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
