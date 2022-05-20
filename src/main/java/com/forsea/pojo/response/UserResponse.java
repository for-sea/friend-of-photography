package com.forsea.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @program: friend-of-photography
 * @description: 渲染给普通用户的个人信息
 * @author: 肖四海
 * @create: 2022-05-10 23:45
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer uid; // 用户id
    private String username; // 用户名
    private String email; // 电子邮件
    private String sex; // 性别
    private String city; // 所在城市
    private String photo; // 个人照片
    private String job; // 职业
    private String role; // 用户角色
    private Timestamp birthday; // 出生年月日
    private Timestamp createTime; // 创建时间
    private Timestamp updateTime; // 更新时间
}
