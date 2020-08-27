package com.sjc.dao.impl;

import com.sjc.dao.UserDAO;
import com.sjc.entity.UserDO;
import com.sjc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 用户管理模块的dao组件的实现类
 * @author by SangJiacun
 * @Date 2020/8/13 14:43
 */
@Repository
public class UserDAOImpl implements UserDAO {

    /**
     * 用户管理模块的mapper组件
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户ID查找用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
    public UserDO findById(Integer id) {
        return userMapper.findById(id);
    }
}
