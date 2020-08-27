package com.sjc.service.impl;

import com.sjc.dao.UserDAO;
import com.sjc.domain.UserDO;
import com.sjc.domain.UserDTO;
import com.sjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

/**
 * 用户管理模块的service组件实现类
 * @author by SangJiacun
 * @Date 2020/8/13 14:45
 */
@Service
public class UserServiceImpl implements UserService {
    private final BeanCopier beanCopier = BeanCopier.create(UserDO.class, UserDTO.class, false);

    /**
     * 用户管理模块的dao组件
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * 根据用户ID查找用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
    public UserDTO findById(Integer id) {
//        try {
//            // 测试服务超时，熔断
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.err.println(e.getMessage());
//        }
        UserDTO userDTO = new UserDTO();
        beanCopier.copy(userDAO.findById(id),userDTO,null);
        return userDTO;
    }
}
