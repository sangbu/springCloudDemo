package com.sjc.service;

import com.sjc.entity.UserVO;

/**
 * @author by SangJiacun
 * @Date 2020/8/14 18:14
 */
public interface UserService {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    UserVO findUserByIdWithUserService(Integer id);
}
