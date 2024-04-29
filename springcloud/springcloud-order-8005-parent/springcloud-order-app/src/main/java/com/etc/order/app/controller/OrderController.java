package com.etc.order.app.controller;

import com.etc.order.api.Result.ReturnResult;
import com.etc.order.api.dto.MasterOrderDTO;
import com.etc.order.api.dto.PayOrderDTO;
import com.etc.order.api.dto.PlaseOrderDTO;
import com.etc.order.api.facade.IOrderFacade;
import com.etc.order.app.convert.OrderDTOConvert;
import com.etc.order.service.bo.ReturnResultBo;
import com.etc.order.service.manager.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单Controller
 * @author 刘宇祥
 * */
@RestController
public class OrderController implements IOrderFacade {
    @Autowired
    private OrderManager orderManager;

    @Autowired
    private OrderDTOConvert orderDTOConvert;

    @Override
    public List<MasterOrderDTO> queryOrderBySku(String skuId) {
        return orderDTOConvert.toDTOList(orderManager.queryOrderBySku(skuId));
    }

    @Override
    public ReturnResult placeOrder(PlaseOrderDTO plaseOrderDTO) throws Exception {
        ReturnResultBo returnResultBo=orderManager.placeOrder(orderDTOConvert.toPlaseOrderBo(plaseOrderDTO));
        return orderDTOConvert.toReturnResult(returnResultBo);
    }

    @Override
    public ReturnResult payOrder(PayOrderDTO payOrderDTO) throws Exception {
        ReturnResultBo returnResultBo=orderManager.payOrder(orderDTOConvert.toPayOrderBo(payOrderDTO));
        return orderDTOConvert.toReturnResult(returnResultBo);
    }

}
