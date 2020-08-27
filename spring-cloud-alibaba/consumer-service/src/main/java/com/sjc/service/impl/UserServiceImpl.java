package com.sjc.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sjc.entity.UserVO;
import com.sjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author by SangJiacun
 * @Date 2020/8/14 18:15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据id查询用户信息
     * @SentinelResource 注解作用：设置服务降级处理方法和服务限流处理方法
     * value属性 设置被降级或限流方法
     * fallback属性 设置服务降级处理方法
     * blockHandler属性 设置服务限流处理方法
     * @param id
     * @return
     */
    @Override
    @SentinelResource(value = "findUserByIdWithUserService",fallback = "fallbackMethod",blockHandler = "blockMethod")
    public UserVO findUserByIdWithUserService(Integer id) {
        // 使用ribbon负载均衡器，同时配置了注册中心
        // 才可以使用服务名称访问对应服务，暂时使用host加端口访问
        String url = "http://user-service/user/" + id;
        UserVO user = restTemplate.getForObject(url, UserVO.class);
        return user;
    }

    //创建服务降级方法，与被降级方法返回值保持一致，参数保持一致
    public UserVO fallbackMethod(Integer id) {
        UserVO user = new UserVO();
        user.setNote("服务--降级--处理了~");
        return user;
    }
    //创建服务限流方法，与被降级方法返回值保持一致，参数保持一致，除了参数保持一致，还需要加一个参数blockexception
    public UserVO blockMethod(Integer id) {
        UserVO user = new UserVO();
        user.setNote("服务--限流--处理了~");
        return user;
    }
}
