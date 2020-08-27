package com.sjc.springcloudapollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by SangJiacun
 * @Date 2020/8/14 22:36
 */
@RestController
public class HelloController {
    //获取配置中心中的配置personName
    @Value("${personName}")
    private String name;

    @GetMapping("sayHello")
    public String getConfig(){
        return "Apollo config personName = "+name;
    }
}
