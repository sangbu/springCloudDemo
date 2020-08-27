package com.sjc.api;

import com.sjc.config.FeignConfiguration;
import com.sjc.domain.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign客户端接口：接口的作用，将请求调用封装到当前的接口中
 * 使用的时候，直接注入Controller即可使用！
 * @FeignClient()在注解的作用，声明当前接口为feign客户端接口
 * value属性：设置访问服务的名称
 * fallback属性：设置服务降级的处理方法
 * configuration属性：设置Feign的配置类
 * @author by SangJiacun
 * @Date 2020/8/14 10:33
 */
@FeignClient(value = "provider-service",
        fallback = UserServiceFallBack.class,
        configuration = FeignConfiguration.class)
public interface UserService {

    @GetMapping("/user/{id}")
    UserVO findById(@PathVariable("id") Integer id);
}
