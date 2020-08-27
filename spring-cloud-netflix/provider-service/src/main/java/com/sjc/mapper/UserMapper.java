package com.sjc.mapper;

import com.sjc.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户管理模块的mapper组件接口
 * @author by SangJiacun
 * @Date 2020/8/13 14:28
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户ID查找用户信息
     * @param id 用户id
     * @return 用户信息
     */
    UserDO findById(Integer id);
}
