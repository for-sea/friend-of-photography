package com.forsea.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * 帖子实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDO {
    private Integer pid; // 帖子id

    @NotNull(message = "用户id不能为空")
    private Integer uid; // 用户id

    @NotNull(message = "帖子标题不能为空")
    @Length(min = 2, max = 20, message = "帖子标题长度须在2-20位之间")
    private String title; // 帖子标题

    @NotNull(message = "正文不能为空")
    private String text; // 帖子正文

    private Timestamp createTime; // 创建时间

    private Timestamp updateTime; // 更新时间
}
