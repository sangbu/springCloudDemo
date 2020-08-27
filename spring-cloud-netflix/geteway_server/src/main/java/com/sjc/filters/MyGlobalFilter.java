package com.sjc.filters;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 * 实现了全局过滤器的接口GlobalFilter，Ordered
 * 注意：自定义全局过滤器必须注入Spring的容器中
 * @author by SangJiacun
 * @Date 2020/8/14 14:23
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    /**
     * 拦截所有的http请求：经过网关的http请求
     * @param exchange 交换器
     * @param chain 网关的过滤器栈
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        /**
         * 从请求中获取参数，token
         * 判断token是否存在
         * 如果存在，那么就放行
         * 如果不存在，就拦截，并且提示用户未授权！
         */
        //1、从请求中获取参数，token，获取请求对象，获取响应对象
        //请求对象
        ServerHttpRequest request = exchange.getRequest();
        //响应对象
        ServerHttpResponse response = exchange.getResponse();
        //2、从请求对象中，获取请求参数token
        String token = request.getQueryParams().getFirst("token");
        //3、判断请求是否存贮

        // if (token == null || "".equals(token)) {
        if (StringUtils.isEmpty(token)) {
            //如果不存在，进行权限拦截
            //提示用户未授权
            /**
             * HttpStatus.UNAUTHORIZED http的状态码的枚举类
             * 设置用户响应的状态码！
             */
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();//进行拦截

        }
        //如果存在，放行
        return chain.filter(exchange);//放行
    }

    /**
     * 方法的返回值，决定了当前拦截器在拦截器栈中的执行顺序
     * 返回值越小，执行顺序越靠前！
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
