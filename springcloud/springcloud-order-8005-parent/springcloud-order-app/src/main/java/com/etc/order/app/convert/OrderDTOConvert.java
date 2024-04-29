package com.etc.order.app.convert;

import com.etc.order.api.Result.ReturnResult;
import com.etc.order.api.dto.MasterOrderDTO;
import com.etc.order.api.dto.PayOrderDTO;
import com.etc.order.api.dto.PlaseOrderDTO;
import com.etc.order.repository.entity.MasterOrder;
import com.etc.order.service.bo.PayOrderBo;
import com.etc.order.service.bo.PlaseOrderBo;
import com.etc.order.service.bo.ReturnResultBo;

import java.util.List;


public interface OrderDTOConvert {

    List<MasterOrderDTO> toDTOList(List<MasterOrder> masterOrders);

    MasterOrder toMasterOrder(MasterOrderDTO masterOrderDTO);

    PlaseOrderBo toPlaseOrderBo(PlaseOrderDTO plaseOrderDTO);

    ReturnResult toReturnResult(ReturnResultBo returnResultBo);


    PayOrderBo toPayOrderBo(PayOrderDTO payOrderDTO);
}
