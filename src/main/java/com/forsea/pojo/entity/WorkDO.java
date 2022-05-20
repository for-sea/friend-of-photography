package com.forsea.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 摄影作品实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkDO {
    private Integer wid; // 作品id

    private Integer uid; // 用户id

    private String introduction; // 作品简介

    private String url; // 作品url

    private Timestamp createTime; // 创建时间

    private Timestamp updateTime; // 更新时间
}
