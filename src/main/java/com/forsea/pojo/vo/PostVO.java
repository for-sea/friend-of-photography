package com.forsea.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @program: friend-of-photography
 * @description: 帖子更新的信息
 * @author: 肖四海
 * @create: 2022-05-12 21:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostVO {
    private Integer uid; // 用户id
    private String title; // 帖子标题
    private String text; // 帖子正文
    private Timestamp updateTime; // 更新时间
}
