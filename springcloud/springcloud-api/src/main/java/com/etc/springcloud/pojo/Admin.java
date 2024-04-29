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
public class Admin implements Serializable { //user 实体类，orm 类表关系映射
   private int id;
   private String adminName;
   private String adminCode;
   private String adminPassword;

    public Admin(String adminName, String adminCode, String adminPassword) {
        this.adminName = adminName;
        this.adminCode = adminCode;
        this.adminPassword = adminPassword;
    }
}
