package com.forsea.pojo.entity;

import com.forsea.config.EnumString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * 板块文章实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDO {
    private Integer aid; // 文章id

    @NotNull(message = "用户id不能为空")
    private Integer uid; // 用户id

    @NotNull(message = "所属版块不能为空")
    @EnumString(value = {"摄影器材", "摄影技术", "摄影作品", "摄影培训", "摄影旅游", "论坛"}, message = "版块不存在")
    private String tag; // 所属板块

    @NotNull(message = "文章标题不能为空")
    @Length(min = 2, max = 20, message = "文章标题长度须在2-20位之间")
    private String title; // 文章标题

    @NotNull(message = "正文内容不能为空")
    private String text; // 文章正文

    private Timestamp createTime; // 创建时间

    private Timestamp updateTime; // 修改时间
}
