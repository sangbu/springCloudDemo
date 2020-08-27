package com.sjc.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author by SangJiacun
 * @Date 2020/8/26 14:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private List<String> roles;
}
