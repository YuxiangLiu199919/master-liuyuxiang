package com.etc.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Orders implements Serializable {
    private Integer oid;
    private Integer user_id;
    private Integer address_id;
    private Date create_time;
    private Integer quantity;
    private Double price_total;
    private Integer isPay;
    private String orderNum;
    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;



    public String  getCreateTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(create_time);
    }

}
