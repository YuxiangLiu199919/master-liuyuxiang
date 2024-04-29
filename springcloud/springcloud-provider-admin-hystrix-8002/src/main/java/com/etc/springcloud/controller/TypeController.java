package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.Type;
import com.etc.springcloud.pojo.User;
import com.etc.springcloud.service.TypeService;
import com.etc.springcloud.service.UserService;
import com.etc.springcloud.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//提供restful服务
@Controller
public class TypeController {

    @Resource
    private UserService userService;

    @Resource
    private TypeService typeService;

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
//查询商品类型
    @RequestMapping("/typeList")
    @ResponseBody
    public String TypeList(String type_name,String pageIndex){
        int pageSize= Constants.pageSize;
        int currentPageNo=1;
        if(pageIndex!=null&&pageIndex!="") {
            currentPageNo=Integer.valueOf(pageIndex);
        }else {
            currentPageNo=1;
        }
        PageInfo<Type> pages =typeService.getTypeList(type_name, currentPageNo, pageSize);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("pages", pages);
        return JSON.toJSONString(map);
    }
//根据TypeID查询商品类型
    @RequestMapping("/getTypeById")
    @ResponseBody
    public String queryTypeById( int tid){
        Type type=typeService.queryTypeById(tid);

        return JSON.toJSONString(type);

    }
//查询类型
    @RequestMapping("/queryTypeList")
    @ResponseBody
    public String queryTypeList(){
        List<Type> list=typeService.queryTypeList();
        return JSON.toJSONString(list);

    }

    @RequestMapping("/modifyTypeById")
    @ResponseBody
    public String modifyTypeById(Model model, int tid,String type_name){
//        int id=Integer.valueOf(tid);
        Map<String,String> map=new HashMap<String,String>();

        Type type=typeService.queryTypeById(tid);
        if(type!=null){
            if(typeService.modifyType(tid,type_name)){
                map.put("flag","true");
            }else{
                map.put("flag","false");
            }
        }else{
            map.put("flag","false");
        }

        return JSON.toJSONString(map);


    }

    @RequestMapping("/addType")
    @ResponseBody
    public String addType(Model model,String type_name){
        Map<String,String> map=new HashMap<String,String>();
        System.out.println(type_name);
        if(!"".equals(type_name.trim()) && type_name!=null){
            int result=typeService.addType(type_name);
            if(result>=0){
                map.put("flag","true");
            }else{
                map.put("flag","false");
            }
        }else{
            map.put("flag","false");
        }

        return JSON.toJSONString(map);


    }

    @RequestMapping("/deleteTypeById")
    @ResponseBody
    public String deleteType( int tid){
        Map<String,String> map=new HashMap<String,String>();
        if(tid>0){
            int result=typeService.deleteType(tid);
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return JSON.toJSONString(map);
    }
//批量删除
    @RequestMapping("/delTypeAllById")
    @ResponseBody
    public String delTypeAllById( List<Integer> tid){
        Map<String,String> map=new HashMap<String,String>();
        if(tid!=null){
            int result=typeService.delTypeAllById(tid);
            map.put("flag","true");
        }else{
            map.put("flag","false");
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
