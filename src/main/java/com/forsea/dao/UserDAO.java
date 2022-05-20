package com.forsea.dao;

import com.forsea.pojo.entity.UserDO;
import com.forsea.pojo.vo.UserVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: 对user表进行数据操作
 * @author: 肖四海
 * @create: 2022-05-09 11:07
 **/
@Mapper
@Repository
public interface UserDAO {
    /* "<script>insert into user (" +
             "<if test='username != null'>username,</if>" +
             "<if test='password != null'>password,</if>" +
             "<if test='email != null'>email,</if>" +
             "<if test='sex != null'>sex,</if>" +
             "<if test='city != null'>city,</if>" +
             "<if test='photo != null'>photo,</if>" +
             "<if test='job != null'>job,</if>" +
             "<if test='role != null'>role,</if>" +
             "<if test='birthday != null'>birthday,</if>" +
             "<if test='createTime != null'>create_time,</if>" +
             "<if test='updateTime != null'>update_time</if>" +
             ") values (" +
             "<if test='username != null'>#{username},</if>" +
             "<if test='password != null'>#{password},</if>" +
             "<if test='email != null'>#{email},</if>" +
             "<if test='sex != null'>#{sex},</if>" +
             "<if test='city != null'>#{city},</if>" +
             "<if test='photo != null'>#{photo},</if>" +
             "<if test='job != null'>#{job},</if>" +
             "<if test='role != null'>#{role},</if>" +
             "<if test='birthday != null'>#{birthday},</if>" +
             "<if test='createTime != null'>#{createTime},</if>" +
             "<if test='updateTime != null'>#{updateTime}</if>" +
             ")</script>"*/
    /* 添加用户 */
    @Insert("insert into user(username, password, email, sex, city, photo, job, role, birthday) " +
            "values(#{username}, #{password}, #{email}, #{sex}, #{city}, #{photo}, #{job}, #{role}, #{birthday})")
    void insertUser(UserDO user);

    /* 删除用户 */
    @Delete("delete from user where uid = #{uid}")
    void deleteUser(Integer uid);

    /* 普通用户更新用户 */
    @Update("update user set " +
            "username=#{username}, password=#{newPassword}, email=#{email}, sex=#{sex}," +
            "city=#{city}, photo=#{photo}, job=#{job}, birthday=#{birthday} " +
            "where uid=#{uid}")
    void updateUser(UserVO user);

    /* 系统管理员更新用户 */
    @Update("update user set " +
            "username=#{username}, password=#{password}, email=#{email}, sex=#{sex}," +
            "city=#{city}, photo=#{photo}, job=#{job}, role=#{role}, birthday=#{birthday}" +
            "where uid=#{uid}")
    void updateUserAdmin(UserDO user);

    /* 查询用户信息 */
    @Select("select * from user where uid=#{uid}")
    @Results(id = "User", value = {
            @Result(id = true, column = "uid", property = "uid"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "email", property = "email"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "city", property = "city"),
            @Result(column = "photo", property = "photo"),
            @Result(column = "job", property = "job"),
            @Result(column = "role", property = "role"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    @Options(keyColumn = "uid", keyProperty = "uid", useGeneratedKeys = true)
    UserDO selectByUid(Integer uid);

    /* 查询用户列表 */
    @Select("select * from user;")
    @ResultMap(value = "User")
    List<UserDO> selectAllUsers();
}
