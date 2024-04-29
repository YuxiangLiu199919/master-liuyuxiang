package com.etc.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data //get,set,toString
@NoArgsConstructor //无参构造
@AllArgsConstructor //全参
@Accessors(chain = true) //支持链式写法
public class Love implements Serializable {
    private Integer lid;
    private Integer l_gid;
    private String loveGoodsName;
    private Double loveGoodsPrice;
    private String loveGoodsImage;
    private Double loveGoodsDiscount;

}
