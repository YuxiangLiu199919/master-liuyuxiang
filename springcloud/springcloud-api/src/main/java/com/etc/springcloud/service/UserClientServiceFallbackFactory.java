package com.etc.springcloud.service;

import com.etc.springcloud.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
//熔断降级
@Component
public class UserClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public UserClientService create(Throwable throwable) {
        return new UserClientService() {
            @Override
            public User queryById(int id) {
                return new User()
                         .setUid(id)
                        .setUserName("uid=>"+id+"没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭了--@Hystrix")
                        .setUserPhone("null")
                        .setUserEmail("null")
                        .setSex(0)
                        .setUserPassword("null");
            }

            @Override
            public List<User> queryAll() {
                return null;
            }

            @Override
            public Boolean addUser(User user) {
                return null;
            }
        };
    }
}
