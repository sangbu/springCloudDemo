package com.sjc.controller;

import com.sjc.entity.UserVO;
import com.sjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务表现层
 * @author by SangJiacun
 * @Date 2020/8/14 18:17
 */
@RestController
public class ConsumerController {

    @Autowired
    private UserService userService;

    @GetMapping("/consumer/{id}")
    public UserVO consumerUser(@PathVariable("id") Integer id){
        return userService.findUserByIdWithUserService(id);
    }
}
