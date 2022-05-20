package com.forsea.pojo.entity;

import com.forsea.config.ValidGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.List;

/**
 * 用户实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "用户id不能为空")
    private Integer uid; // 用户id

    @Length(min = 1, max = 10, message = "用户名长度须在1-10位之间")
    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    private String username; // 用户名

    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,16}$", message = "密码长度须在4-16位，包含数字和字母")
    private String password; // 密码

    @Email(message = "请填写正确的邮箱地址")
    private String email; // 电子邮件

    private String sex; // 性别

    private String city; // 所在城市

    private String photo; // 个人照片

    private String job; // 职业

    @NotNull(message = "用户权限不能为空")
    private String role; // 用户角色

    private Timestamp birthday; // 出生年月日

    private Timestamp createTime; // 创建时间

    private Timestamp updateTime; // 更新时间
}
