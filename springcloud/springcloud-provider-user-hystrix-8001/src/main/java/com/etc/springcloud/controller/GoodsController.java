package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.*;
import com.etc.springcloud.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//提供restful服务
@Controller
public class GoodsController {

    @Resource
    private GoodsService goodsService;
    @Resource
    private TypeService typeService;
    @Resource
    private LoveService loveService;
    @Resource
    private CartService cartService;
    @Resource
    private AddressService addressService;
    @Resource
    private OrdersService ordersService;
    @Resource
    private OdetailsService odetailsService;

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
//获取页面的商品信息，收藏，页面小购物车信息
    @RequestMapping("user/getGoods")
    @ResponseBody
    public String getGoods(int uid){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Goods> goodsList=goodsService.queryGoods();
        List<Goods> SpecialGoodList=goodsService.querySpecialGoods();
        List<Type> typeList=typeService.queryType();
        List<Love> loveList=loveService.queryLove(uid);
        List<Cart> cartsList=cartService.queryCart(uid);
        Cart cart=cartService.queryCartTotalPrice(uid);
        Address address=addressService.queryAddress(uid);
        List<Orders> ordersList=ordersService.queryOrders(uid);
        map.put("ordersList",ordersList);
        map.put("address",address);
        map.put("cart",cart);
        map.put("cartsList",cartsList);
        map.put("goodsList",goodsList);
        map.put("SpecialGoodList",SpecialGoodList);
        map.put("typeList",typeList);
        map.put("loveList",loveList);
        return JSON.toJSONString(map);

    }
    //获取页面的商品信息，收藏，页面小购物车信息
    @RequestMapping("user/getGoods2")
    @ResponseBody
    public String getGoods2(int uid,int oid){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Goods> goodsList=goodsService.queryGoods();
        List<Goods> SpecialGoodList=goodsService.querySpecialGoods();
        List<Type> typeList=typeService.queryType();
        List<Love> loveList=loveService.queryLove(uid);
        List<Cart> cartsList=cartService.queryCart(uid);
        Cart cart=cartService.queryCartTotalPrice(uid);
        Address address=addressService.queryAddress(uid);
        List<Odetails> odetailsList=odetailsService.queryOdetails(oid);
        List<Orders> ordersList=ordersService.queryOrders(uid);
        map.put("ordersList",ordersList);
        map.put("odetailsList",odetailsList);
        map.put("address",address);
        map.put("cart",cart);
        map.put("cartsList",cartsList);
        map.put("goodsList",goodsList);
        map.put("SpecialGoodList",SpecialGoodList);
        map.put("typeList",typeList);
        map.put("loveList",loveList);
        return JSON.toJSONString(map);

    }
//根据商品ID查询商品信息
    @RequestMapping("user/getGoodsById")
    @ResponseBody
    public String getGoodsById(int gid){
        Map<String,Object> map=new HashMap<String,Object>();
        Goods goods=goodsService.getGoodsById(gid);
        map.put("goods",goods);
        return JSON.toJSONString(map);
    }
    //根据商品类型查询商品
    @RequestMapping("user/queryGoodsByTypeId")
    @ResponseBody
    public String queryGoodsByTypeId(int tid){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Goods> listGoods=goodsService.queryGoodsByTypeId(tid);
        map.put("listGoods",listGoods);
        return JSON.toJSONString(map);
    }

    //模糊查询商品信息
    @RequestMapping("user/queryGoodsByName")
    @ResponseBody
    public String queryGoodsByName(String name){
        Map<String,Object> map=new HashMap<String,Object>();

        if(name!=null){
            List<Goods> goodsList=goodsService.queryGoodsByName(name);
            if(goodsList.size()>0){
                map.put("flag","true");
                map.put("goodsList",goodsList);
            }else{
                map.put("flag","false");
            }
        }else{
            map.put("flag","false");
        }

        return JSON.toJSONString(map);
    }

    //收藏商品
    @RequestMapping("user/addGoodsLove")
    @ResponseBody
    public String addGoodsLove(int gid,int uid){
        Map<String,Object> map=new HashMap<String,Object>();
//        User loginUser=(User)session.getServletContext().getAttribute(request.getHeader("token"));
//        int uid= loginUser.getUid();
        int result=loveService.getLoveById(gid);
        if(result>0){
            loveService.deleteLove(gid);
            List<Love> loveList=loveService.queryLove(uid);
            map.put("loveList",loveList);
            map.put("flag","false");
        }else{

            if(loveService.addLove(gid,uid)){
                List<Love> loveList=loveService.queryLove(uid);
                map.put("loveList",loveList);
                map.put("flag","true");
            }else{
                map.put("flag","false");
            }
        }

        return JSON.toJSONString(map);
    }
    //查询收藏的商品
    @RequestMapping("user/queryGoodsLove")
    @ResponseBody
    public String queryGoodsLove(int uid){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Love> loveList=loveService.queryLove(uid);
        map.put("loveList",loveList);
        return JSON.toJSONString(map);
    }
    //删除收藏的商品
    @RequestMapping("user/deleteGoodsLove")
    @ResponseBody
    public String deleteGoodsLove(int gid){
        Map<String,Object> map=new HashMap<String,Object>();
        if(loveService.deleteLove(gid)){
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return JSON.toJSONString(map);
    }



    //备选方案
//    public String hystrixGet(@PathVariable("uid") int uid){
//        return "服务中断";
//    }
}
