package com.sjc.demo.controller;

import com.sjc.demo.domain.UserDTO;
import com.sjc.demo.holder.LoginUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取登录用户信息接口
 * @author by SangJiacun
 * @Date 2020/8/26 14:29
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LoginUserHolder loginUserHolder;

    @GetMapping("/currentUser")
    public UserDTO currentUser() {
        return loginUserHolder.getCurrentUser();
    }
}
