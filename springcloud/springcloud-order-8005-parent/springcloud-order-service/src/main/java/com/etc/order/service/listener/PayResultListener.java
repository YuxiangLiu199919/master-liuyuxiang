package com.etc.order.service.listener;


import com.etc.order.service.constants.Constant;
import com.etc.order.service.listener.event.PayResultEvent;
import com.etc.order.service.strategy.PayContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Optional;

@Component
public class PayResultListener {

    @Autowired
    private PayContext payContext;

    @TransactionalEventListener
    @Async(Constant.SYNC_EXECUTOR)
    public void doPayResult(PayResultEvent payResultEvent){
        if(!verify(payResultEvent)){
            return;
        }
        payContext.executePayment(payResultEvent.getPayOrderBo(),payResultEvent.getFlag());


    }

    /**
     * 校验监听参数
     * */
    private Boolean verify(PayResultEvent payResultEvent){
        if(!Optional.ofNullable(payResultEvent).isPresent()){
            return false;
        }
        if(!Optional.ofNullable(payResultEvent.getPayOrderBo()).isPresent()){
            return false;
        }
        if(!Optional.ofNullable(payResultEvent.getFlag()).isPresent()){
            return false;
        }
        return true;
    }
}
