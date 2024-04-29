package com.etc.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Type implements Serializable {
    private Integer tid;
    private String type_name;

    public Type(String type_name) {
        this.type_name = type_name;
    }
}
