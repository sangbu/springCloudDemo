package com.sjc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sjc.api.UserService;
import com.sjc.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费服务的controller组件
 * @author by SangJiacun
 * @Date 2020/8/13 15:15
 */
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "defaultFallback") //开启默认的FallBack，统一失败降级方法(兜底)
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 发送http请求调用provider服务根据id查找用户的接口
     */
    @GetMapping("/findUserById/{id}")
    @HystrixCommand
    public UserVO findUserById(@PathVariable Integer id){
        //String url = "http://127.0.0.1:9091/user/" + id;
        String url = "http://provider-service/user/" + id;
        UserVO user = restTemplate.getForObject(url, UserVO.class);
        return user;
    }


    //熔断方法
    public UserVO fallBackMethod(Integer id){
        UserVO user = new UserVO();
        user.setId(id);
        user.setName("熔断方法");
        return user;
    }

    /**
     * 默认降级方法
     */
    public UserVO defaultFallback(){
        UserVO user = new UserVO();
        user.setName("默认提示：对不起，网络太拥挤了！");
        return user;
    }

    @GetMapping("/queryById/{id}")
    public UserVO queryById(@PathVariable Integer id){
        //1、获取Eureka中注册的provider-service实例列表
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("provider-service");
        //2、获取实例
        ServiceInstance serviceInstance = serviceInstanceList.get(0);
        //3、根据实例的信息拼接的请求地址
        String url = serviceInstance.getUri()+ "/user/" + id;
        System.out.println(url);
        UserVO user = restTemplate.getForObject(url, UserVO.class);
        return user;
    }

    /**
     * 获取元数据信息
     */
    @GetMapping("/getMetaData")
    public List<ServiceInstance> getMetaData(){
        List<ServiceInstance> instances = discoveryClient.getInstances("provider-service");
        return instances;
    }

}
