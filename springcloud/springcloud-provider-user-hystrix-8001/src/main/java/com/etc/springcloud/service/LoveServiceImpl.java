package com.etc.springcloud.service;

import com.etc.springcloud.mapper.LoveMapper;
import com.etc.springcloud.pojo.Love;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoveServiceImpl implements LoveService{
    @Resource
    private LoveMapper loveMapper;


    @Override
    public boolean addLove(int gid,int uid) {
        return loveMapper.addLove(gid, uid);
    }

    @Override
    public List<Love> queryLove(int uid) {
        return loveMapper.queryLove(uid);
    }

    @Override
    public int getLoveById(int gid) {
        return loveMapper.getLoveById(gid);
    }

    @Override
    public boolean deleteLove(int gid) {
        return loveMapper.deleteLove(gid);
    }
}
