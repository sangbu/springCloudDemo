package com.sjc.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign客户端的配置类
 * 配置日志级别：
 * 动态的注入配置信息到Spring的容器中
 * @author by SangJiacun
 * @Date 2020/8/14 11:01
 */
@Configuration
public class FeignConfiguration {
    /**
     * 动态的注入配置信息到Spring的容器中
     * 四种日志级别：
     * None：没有日志
     * Basic：基本的日志，请求方法，请求URL地址，响应的状态码，请求执行时间
     * Headers：与BASIC的日志基本一样，多请求的头部信息Header
     * Full：全部的日志信息，请求的体，响应的体
     *
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
