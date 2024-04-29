package com.etc.order.service.factory.impl;

import com.etc.order.service.factory.PayService;
import org.springframework.stereotype.Service;

@Service
public class PaySuccessImpl implements PayService {


    @Override
    public boolean doAction() {
        return false;
    }

    @Override
    public boolean isAction() {
        return false;
    }
}
