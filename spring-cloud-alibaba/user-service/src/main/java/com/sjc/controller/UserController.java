package com.sjc.controller;

import com.sjc.entity.UserDTO;
import com.sjc.entity.UserVO;
import com.sjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanCopier;
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
public class UserController {
    private final BeanCopier beanCopier = BeanCopier.create(UserDTO.class, UserVO.class, false);

    @Value("${server.port}")
    private String port;

    /**
     * 用户管理模块的service组件
     */
    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return
     */
    @GetMapping("/{id}")
    public UserVO findById(@PathVariable("id") Integer id){
        UserVO user = new UserVO();
        beanCopier.copy(userService.findById(id),user,null);
        //设置端口信息
        user.setNote("端口 : "+port+" ;");
        return  user;
    }
}
