package com.etc.springcloud.controller;

import com.alipay.api.AlipayApiException;
import com.etc.springcloud.epay.AlipayBean;
import com.etc.springcloud.service.OrdersService;
import com.etc.springcloud.service.alipay.AlipayService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AlipayController {

    @Autowired
    private AlipayService alipayService;
    @Resource
    private OrdersService ordersService;
    //支付
    @RequestMapping("user/alipay")
    @ResponseBody
    public String AliPay(int oid,String subject,String totalMoney) throws AlipayApiException {
        Map<String,Object> map=new HashMap<String,Object>();
        String outTradNo=ordersService.getOrderNum(oid);

        AlipayBean alipayBean=new AlipayBean();
        alipayBean.setOut_trade_no(outTradNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalMoney);
        return alipayService.alipay(alipayBean);
    }


    /**
     * 模拟支付
     *
     * */
    @RequestMapping("user/pay")
    @ResponseBody
    public Boolean pay(Double money,String orderId) {
        if(StringUtils.isNotBlank(orderId) && money !=null ){
            return true;
        }
        //模拟支付返回
        return false;
    }
}
