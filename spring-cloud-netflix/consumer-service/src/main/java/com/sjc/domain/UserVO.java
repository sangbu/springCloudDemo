package com.sjc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户管理模块的用户VO类
 * @author by SangJiacun
 * @Date 2020/8/13 15:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别 1男性，2女性
     */
    private Integer sex;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 更新时间
     */
    private Date updated;
    /**
     * 备注
     */
    private String note;
}
