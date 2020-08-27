package com.sjc.mapper;

import com.sjc.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
    @Select("select * from nacos_user where id=#{id};")
    UserDO findById(Integer id);
}
