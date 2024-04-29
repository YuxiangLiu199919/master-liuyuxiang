package com.etc.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Cart implements Serializable {
    private Integer cid;
    private Integer user_id;
    private Integer product_id;
    private Integer amount;
    private Integer TotalAmount;
    private String GoodsName;
    private BigDecimal GoodsPrice;
    private BigDecimal GoodsDiscount;
    private BigDecimal GoodsTotalPrice;
    private String GoodsImage;


}
