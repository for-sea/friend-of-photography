package com.forsea.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: friend-of-photography
 * @description: 用户登录所需信息
 * @author: 肖四海
 * @create: 2022-05-12 16:36
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    private Integer uid; // 用户id
    private String username; // 用户名
    private String password; // 密码
}
