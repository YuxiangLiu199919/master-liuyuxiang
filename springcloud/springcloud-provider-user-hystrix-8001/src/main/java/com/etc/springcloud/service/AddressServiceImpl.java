package com.etc.springcloud.service;

import com.etc.springcloud.mapper.AddressMapper;
import com.etc.springcloud.pojo.Address;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;


    @Override
    public boolean addAddress(int uid, String receiver_name, String receiver_address, String receiver_phone) {
        return addressMapper.addAddress(uid, receiver_name, receiver_address, receiver_phone);
    }

    @Override
    public boolean updateAddress(int uid, String receiver_name, String receiver_address, String receiver_phone) {
        return addressMapper.updateAddress(uid, receiver_name, receiver_address, receiver_phone);
    }

    @Override
    public Address queryAddress(int uid) {
        return addressMapper.queryAddress(uid);
    }


}
