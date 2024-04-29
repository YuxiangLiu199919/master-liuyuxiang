package com.etc.springcloud.service.alipay;

import com.alipay.api.AlipayApiException;
import com.etc.springcloud.epay.Alipay;
import com.etc.springcloud.epay.AlipayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AlipayService")
public class AlipayServiceImpl implements AlipayService{

    @Autowired
    private Alipay alipay;
    @Override
    public String alipay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}
