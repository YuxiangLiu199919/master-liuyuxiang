package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.Cart;
import com.etc.springcloud.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//提供restful服务
@Controller
public class OrdersController {

    @Resource
    private OrdersService ordersService;
    @Resource
    private AddressService addressService;
    @Resource
    private GoodsService goodsService;

    @Resource
    private CartService cartService;
    @Resource
    private OdetailsService odetailsService;
    //添加订单，添加订单详情
    @RequestMapping("/user/addOrders")
    @ResponseBody
    public String useraddOrders(int uid, Double price_total, int quantity){
        Map<String,Object> map=new HashMap<String,Object>();
//        生成订单编码
            String orderNum= String.valueOf(System.currentTimeMillis());
            Boolean result= ordersService.addOrder(uid,quantity,price_total,orderNum);
            if(result){
                List<Cart> cartList=cartService.queryCart(uid);
                int doid=ordersService.getOrdersId(orderNum);
//                List<Integer> gidList=cartList.stream().map(Cart->Cart.getProduct_id()).collect(Collectors.toList());
                for (int i=0;i<cartList.size();i++){
                    Cart cart=cartList.get(i);
                    BigDecimal price= cart.getGoodsPrice();
                    BigDecimal discount=cart.getGoodsDiscount();
                    BigDecimal dPrice = price.multiply(discount);
                    int dnum=cart.getAmount();
                    int gid=cart.getProduct_id();
//                  根据商品id更新商品库存量
                    Boolean goodsResult=goodsService.upGoodsStocks(gid,dnum);
                    if(goodsResult){
                        String dName=cart.getGoodsName();
//                        添加商品详情信息
                        odetailsService.addOdetails(doid,dName,dPrice,dnum);
                        cartService.deleteCart(uid);
                        map.put("flag","true");
                        map.put("oid",doid);
                    }else{
                        map.put("flag","false");
                    }
                }
            }else{
                map.put("flag","false");
            }
        return JSON.toJSONString(map);
    }
    //更新支付状态
    @RequestMapping("/user/updateOrderPay")
    @ResponseBody
    public String userUpdateOrderPay(String orderNum){

        Map<String,Object> map=new HashMap<String,Object>();
        Boolean result= ordersService.updateOrderPay(orderNum);
        if(result){
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return JSON.toJSONString(map);

    }


}
