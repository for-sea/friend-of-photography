package com.forsea.pojo.vo;

import com.forsea.config.ValidGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.sql.Timestamp;

/**
 * @program: friend-of-photography
 * @description: 普通用户更新个人信息
 * @author: 肖四海
 * @create: 2022-05-10 23:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    @Null(groups = ValidGroup.Crud.Create.class)
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "用户id不能为空")
    private Integer uid; // 用户id

    @Length(min = 1, max = 10, message = "用户名长度须在1-10位之间")
    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    private String username; // 用户名

    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,16}$", message = "密码长度须在4-16位，包含数字和字母")
    private String password; // 密码

    @NotNull(groups = ValidGroup.Crud.Update.class, message = "新密码不能为空")
    @NotBlank(groups = ValidGroup.Crud.Update.class, message = "新密码不能为空")
    @Pattern(groups = ValidGroup.Crud.Update.class, regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,16}$"
            , message = "密码长度须在4-16位，包含数字和字母")
    private String newPassword; // 新密码

    @Email(message = "请填写正确的邮箱地址")
    private String email; // 电子邮件

    private String sex; // 性别

    private String city; // 所在城市

    private String photo; // 个人照片

    private String job; // 职业

    private Timestamp birthday; // 出生年月日

    private Timestamp createTime; // 创建时间

    private Timestamp updateTime; // 更新时间
}
