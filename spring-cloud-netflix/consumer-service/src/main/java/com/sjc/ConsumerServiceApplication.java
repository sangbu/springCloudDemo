package com.sjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient //开启服务发现
@EnableCircuitBreaker //开启熔断
@EnableHystrixDashboard //开启仪表板支持
@EnableFeignClients //开启Feign功能
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

    /**
     * 注册RestTemplate
     * @return
     */
    @Bean
    @LoadBalanced //开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
