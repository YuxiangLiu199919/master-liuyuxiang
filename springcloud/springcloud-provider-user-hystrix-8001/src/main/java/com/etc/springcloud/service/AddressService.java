package com.etc.springcloud.service;

import com.etc.springcloud.pojo.Address;

public interface AddressService {
    /**
     * 添加Address
     * @param
     * @return boolean
     * @
     */
    public boolean addAddress( int uid,String receiver_name,String receiver_address
            ,String receiver_phone);

    /**
     * 更新Address
     * @param
     * @return boolean
     * @
     */
    public boolean updateAddress( int uid,String receiver_name,String receiver_address
            ,String receiver_phone);
    /**
     * 查询Address
     * @param
     * @return Address
     * @
     */
    public Address queryAddress(int uid);
}
