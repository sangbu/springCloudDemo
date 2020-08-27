package com.sjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient//开启注册中心客户端
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

    /**
     * 配置RestTemplate对象，注入Spring容器
     * @return
     */
    @Bean
    @LoadBalanced//开启负载均衡器
    public RestTemplate restTemplate(){return new RestTemplate();}
}
