package com.etc.springcloud.service.alipay;

import com.alipay.api.AlipayApiException;
import com.etc.springcloud.epay.AlipayBean;


public interface AlipayService {

	String alipay(AlipayBean alipayBean) throws AlipayApiException;
}
