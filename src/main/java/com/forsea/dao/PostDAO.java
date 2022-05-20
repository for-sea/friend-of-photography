package com.forsea.dao;

import com.forsea.pojo.entity.ArticleDO;
import com.forsea.pojo.entity.PostDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: 对post表进行数据操作
 * @author: 肖四海
 * @create: 2022-05-10 01:30
 **/
@Mapper
@Repository
public interface PostDAO {
    /* 添加帖子 */
    @Insert("insert into post (uid, title, text) " +
            "values(#{uid}, #{title}, #{text})")
    void insertPost(PostDO post);

    /* 删除文章 */
    @Delete("delete from post where pid = #{pid}")
    void deletePost(Integer pid);

    /* 更新文章 */
    @Update("update post set " +
            "uid=#{uid}, title=#{title}, text=#{text} " +
            "where pid=#{pid}")
    void updatePost(PostDO post);

    /* 查询文章信息 */
    @Select("select * from post where pid=#{pid}")
    @Results(id = "Post", value = {
            @Result(id = true, column = "pid", property = "pid"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "title", property = "title"),
            @Result(column = "text", property = "text"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    @Options(keyColumn = "pid", keyProperty = "pid", useGeneratedKeys = true)
    PostDO selectByPid(Integer pid);

    /* 查询文章列表 */
    @Select("select * from post")
    @ResultMap(value = "Post")
    List<PostDO> selectAllPosts();
}
