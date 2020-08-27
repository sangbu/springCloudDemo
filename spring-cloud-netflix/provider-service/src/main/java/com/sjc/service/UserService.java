package com.sjc.service;

import com.sjc.domain.UserDTO;

/**
 * 用户管理模块的service接口
 * @author by SangJiacun
 * @Date 2020/8/13 14:30
 */
public interface UserService {
    /**
     * 根据用户ID查找用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    UserDTO findById(Integer id);
}
