package com.etc.springcloud.service;

import com.etc.springcloud.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value="SPRINGCLOUD-PROVIDER-USER",fallbackFactory = UserClientServiceFallbackFactory.class)
public interface UserClientService {
    @GetMapping("/user/get/{id}")
    public User queryById(@PathVariable("id") int id);

    @GetMapping("/user/list")
    public List<User> queryAll();

    @PostMapping("/user/add")
    public Boolean addUser(User user);
}
