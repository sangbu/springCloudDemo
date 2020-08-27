package com.sjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient// 开启Eureka客户端发现功能
public class GetewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetewayServerApplication.class, args);
    }

}
