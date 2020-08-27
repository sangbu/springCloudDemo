package com.sjc.controller;

import com.sjc.domain.UserDTO;
import com.sjc.domain.UserVO;
import com.sjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理模块的controller组件
 * @author by SangJiacun
 * @Date 2020/8/13 14:56
 */
@RestController
@RequestMapping("/user")
@RefreshScope //刷新配置
public class UserController {
    private final BeanCopier beanCopier = BeanCopier.create(UserDTO.class, UserVO.class, false);

    /**
     * 用户管理模块的service组件
     */
    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @Value("${test.hello}")
    private String name;

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return
     */
    @GetMapping("/{id}")
    public UserVO findById(@PathVariable("id") Integer id){
        UserVO user = new UserVO();
        beanCopier.copy(userService.findById(id),user,null);
        return  user;
    }

    @GetMapping("/getById/{id}")
    public UserVO getById(@PathVariable("id") Integer id) {
        System.out.println("服务【"+port+"】被调用");
        UserVO user = new UserVO();
        beanCopier.copy(userService.findById(id),user,null);
        user.setNote("服务【"+port+"】被调用");
        user.setName(name);
        return user;
    }
}
