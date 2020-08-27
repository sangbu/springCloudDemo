package com.sjc.api;

import com.sjc.domain.UserVO;
import org.springframework.stereotype.Component;

/**
 * @author by SangJiacun
 * @Date 2020/8/14 10:53
 */
@Component
public class UserServiceFallBack implements UserService{

    @Override
    public UserVO findById(Integer id) {
        UserVO user = new UserVO();
        user.setId(id);
        user.setUsername("用户不存在！！！");
        return user;
    }
}
