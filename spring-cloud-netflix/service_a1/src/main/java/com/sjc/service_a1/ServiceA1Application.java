package com.sjc.service_a1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceA1Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceA1Application.class, args);
    }

}
