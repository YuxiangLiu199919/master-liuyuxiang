package com.etc.order.service.manager;

import com.etc.order.repository.entity.MasterOrder;
import com.etc.order.service.bo.PayOrderBo;
import com.etc.order.service.bo.PlaseOrderBo;
import com.etc.order.service.bo.ReturnResultBo;

import java.util.List;

public interface OrderManager {

    List<MasterOrder> queryOrderBySku(String skuId) ;

    /**
     * 创建订单
     * */
    ReturnResultBo placeOrder(PlaseOrderBo plaseOrderBo);

    ReturnResultBo payOrder(PayOrderBo payOrderBo) throws Exception;
}
