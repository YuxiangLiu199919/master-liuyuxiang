package com.etc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient //在服务启动后，自动注册到Eureka中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //添加对熔断的支持
@EnableHystrixDashboard //开启监控,熔断降级
public class UserProviderHystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderHystrix_8001.class, args);
    }
}
