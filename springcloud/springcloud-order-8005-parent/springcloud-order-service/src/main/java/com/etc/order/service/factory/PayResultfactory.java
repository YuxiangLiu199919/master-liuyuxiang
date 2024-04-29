package com.etc.order.service.factory;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PayResultfactory {

    private static List<PayService> payServiceList;

    @Autowired
    public static void setPayServiceList(List<PayService> payServiceList) {
        PayResultfactory.payServiceList = payServiceList;
    }

    public void doPayResult(){
        payServiceList.forEach(s->{
            if(s.isAction()){
                s.doAction();
            }
        });

    }

}
