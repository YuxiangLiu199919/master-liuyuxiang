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
public class Address implements Serializable { //user 实体类，orm 类表关系映射
    private Integer aid;
    private Integer user_id;
    private String receiver_name;
    private String receiver_address;
    private String receiver_phone;

    public Address(String receiver_name, String receiver_address, String receiver_phone) {
        this.receiver_name = receiver_name;
        this.receiver_address = receiver_address;
        this.receiver_phone = receiver_phone;
    }
}
