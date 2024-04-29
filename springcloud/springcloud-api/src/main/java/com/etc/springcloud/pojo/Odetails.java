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
@Accessors(chain = true) //支持链式写法
public class Odetails implements Serializable {
    private int did;
    private int doid;
    private String dName;
    private BigDecimal dPrice;
    private int dnum;


}
