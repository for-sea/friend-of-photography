package com.forsea.dao;

import com.forsea.pojo.entity.ArticleDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: 对article表进行数据操作
 * @author: 肖四海
 * @create: 2022-05-10 01:30
 **/
@Mapper
@Repository
public interface ArticleDAO {
    /* 添加文章 */
    @Insert("insert into article (uid, tag, title, text) " +
            "values(#{uid}, #{tag}, #{title}, #{text})")
    void insertArticle(ArticleDO article);

    /* 删除文章 */
    @Delete("delete from article where aid = #{aid}")
    void deleteArticle(Integer aid);

    /* 更新文章 */
    @Update("update article set " +
            "uid=#{uid}, tag=#{tag}, title=#{title}, text=#{text} " +
            "where aid=#{aid}")
    void updateArticle(ArticleDO article);

    /* 查询文章信息 */
    @Select("select * from article where aid=#{aid}")
    @Results(id = "Article", value = {
            @Result(id = true, column = "aid", property = "aid"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "tag", property = "tag"),
            @Result(column = "title", property = "title"),
            @Result(column = "text", property = "text"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    @Options(keyColumn = "aid", keyProperty = "aid", useGeneratedKeys = true)
    ArticleDO selectByAid(Integer aid);

    /* 查询文章列表 */
    @Select("select * from article")
    @ResultMap(value = "Article")
    List<ArticleDO> selectAllArticles();
}
