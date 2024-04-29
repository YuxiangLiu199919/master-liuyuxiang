package com.etc.order.api.facade;

import com.etc.order.api.Result.ReturnResult;
import com.etc.order.api.dto.MasterOrderDTO;
import com.etc.order.api.dto.PayOrderDTO;
import com.etc.order.api.dto.PlaseOrderDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api("订单")
@RequestMapping("/order")
public interface IOrderFacade {

    @PostMapping(value = "/queryOrderBySku")
    List<MasterOrderDTO> queryOrderBySku(@RequestParam("skuId") String skuId) throws Exception;

    /**
     * 下单
     * @RequestBody masterOrderDTO
     * */
    @PostMapping(value = "/placeOrder")
    ReturnResult placeOrder(@RequestBody PlaseOrderDTO plaseOrderDTO) throws Exception;

    /**
     * 下单
     * @RequestBody masterOrderDTO
     * */
    @PostMapping(value = "/payOrder")
    ReturnResult payOrder(@RequestBody PayOrderDTO payOrderDTO) throws Exception;

}
