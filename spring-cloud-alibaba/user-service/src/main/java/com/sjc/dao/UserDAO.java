package com.sjc.dao;

import com.sjc.entity.UserDO;
import org.springframework.stereotype.Repository;

/**
 * 用户管理模块的dao组件接口
 * @author by SangJiacun
 * @Date 2020/8/13 14:32
 */
public interface UserDAO {
    /**
     * 根据用户ID查找用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    UserDO findById(Integer id);
}
