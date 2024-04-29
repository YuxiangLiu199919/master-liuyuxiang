package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.Cart;
import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.service.CartService;
import com.etc.springcloud.service.GoodsService;
import com.etc.springcloud.service.LoveService;
import com.etc.springcloud.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//提供restful服务
@Controller
public class CartController {

    @Resource
    private GoodsService goodsService;
    @Resource
    private TypeService typeService;
    @Resource
    private LoveService loveService;
    @Resource
    private CartService cartService;

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

    //查询购物车商品
    @RequestMapping("user/queryCart")
    @ResponseBody
    public String queryCart(int uid){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Cart> cartsList=cartService.queryCart(uid);
        Cart cart=cartService.queryCartTotalPrice(uid);

        map.put("cart",cart);
        map.put("cartsList",cartsList);
        return JSON.toJSONString(map);
    }
    //增加商品到购物车
    @RequestMapping("user/addGoodsToCart")
    @ResponseBody
    public String addGoodsToCart(int gid,int uid){
        Map<String,Object> map=new HashMap<String,Object>();
        Cart cart=cartService.queryCartById(gid, uid);
        if(cart==null){
            if(cartService.addGoodsToCart(gid, uid)){
                List<Cart> cartsList=cartService.queryCart(uid);
                map.put("cartsList",cartsList);
                map.put("flag","true");
            }else{
                map.put("flag","false");
            }
        }else{
            cartService.updataGoodsPquantity(gid, uid);
            map.put("flag","false");
        }

        return JSON.toJSONString(map);
    }

    //减少购物车商品数量
    @RequestMapping("user/updataGoodsMquantity")
    @ResponseBody
    public String updataGoodsMquantity(int gid,int uid){
        Map<String,Object> map=new HashMap<String,Object>();
        Cart cart1=cartService.queryCartById(gid, uid);
        int  result=cart1.getAmount();
        if(result>1){
            if(cartService.updataGoodsMquantity(gid, uid)){
                List<Cart> cartsList=cartService.queryCart(uid);
                Cart cart=cartService.queryCartTotalPrice(uid);
                map.put("cart",cart);
                map.put("cartsList",cartsList);
                map.put("flag","true");
            }else{
                map.put("flag","false");
            }
        }else{
            map.put("flag","false");
        }

        return JSON.toJSONString(map);
    }
    //增加购物车商品数量
    @RequestMapping("user/updataGoodsPquantity")
    @ResponseBody
    public String updataGoodsPquantity(int gid,int uid){
        Map<String,Object> map=new HashMap<String,Object>();
        Cart cart1=cartService.queryCartById(gid, uid);
        int  result=cart1.getAmount();
        Goods goods= goodsService.getGoodsById(gid);
        int goodsStock=goods.getStock();
        if(result<goodsStock){
            if(cartService.updataGoodsPquantity(gid, uid)){
                List<Cart> cartsList=cartService.queryCart(uid);
                Cart cart=cartService.queryCartTotalPrice(uid);
                map.put("cart",cart);
                map.put("cartsList",cartsList);
                map.put("flag","true");
            }else{
                map.put("flag","false");
            }
        }else{
            map.put("flag","false");
        }

        return JSON.toJSONString(map);
    }
    //删除购物车商品
    @RequestMapping("user/deleteCart")
    @ResponseBody
    public String deleteCart(int gid,int uid){
        Map<String,Object> map=new HashMap<String,Object>();
            if(cartService.deleteGoodsCart(gid, uid)){
                List<Cart> cartsList=cartService.queryCart(uid);
                Cart cart=cartService.queryCartTotalPrice(uid);
                map.put("cart",cart);
                map.put("cartsList",cartsList);
                map.put("flag","true");
            }else{
                map.put("flag","false");
            }
        return JSON.toJSONString(map);
    }

    //备选方案
//    public String hystrixGet(int gid,int uid){
//       return "服务中断，请等待!";
//    }
}
