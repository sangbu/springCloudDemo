package com.sjc.demo.api;

/**
 * 封装API的错误码
 * @author by SangJiacun
 * @Date 2020/8/26 12:35
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
