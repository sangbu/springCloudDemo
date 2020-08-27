package com.sjc.controller;

import com.sjc.api.UserService;
import com.sjc.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用feign调用
 * @author by SangJiacun
 * @Date 2020/8/14 10:42
 */
@RestController
public class FeignConsumerController {
    /**
     * 注入Feign客户端接口:优雅的像一首诗！
     * 三个优点：
     * 可复用：哪里需要注入哪里
     * 可读性：有层次结构感觉
     * 易于管理：如果接口地址发送变化，只需要改一次
     */
    @Autowired
    private UserService userService;

    @RequestMapping("/feignconsumer/{id}")
    public UserVO hellofeign(@PathVariable Integer id){
        return userService.findById(id);
    }
}
