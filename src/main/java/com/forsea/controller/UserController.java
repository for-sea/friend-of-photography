package com.forsea.controller;

import com.forsea.config.ValidGroup;
import com.forsea.pojo.entity.UserDO;
import com.forsea.pojo.vo.UserVO;
import com.forsea.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @program: friend-of-photography
 * @description: 个人信息管理模块接口
 * @author: 肖四海
 * @create: 2022-05-10 12:10
 **/
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /* 添加用户 */
    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@Validated(value = ValidGroup.Crud.Create.class) @RequestBody UserDO user){
        userService.saveUser(user);
    }

    /* 根据uid删除用户 */
    @RequestMapping(value = "/{uid}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "uid") Integer uid){
        userService.removeUser(uid);
    }

    /* 普通用户更新用户信息 */
    @RequestMapping(method = RequestMethod.PUT)
    public void modifyUser(@Validated(value = ValidGroup.Crud.Update.class) @RequestBody UserVO user){
        userService.updateUser(user);
    }

    /* 系统管理员更新用户信息 */
    @RequestMapping(value = "/admin", method = RequestMethod.PUT)
    public void modifyUserAdmin(@Validated(value = ValidGroup.Crud.Update.class) @RequestBody UserDO user){
        userService.updateUserAdmin(user);
    }

    /* 普通用户查询个人信息 */
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public UserVO queryByUid(@PathVariable(value = "uid") Integer uid){
        return userService.getByUid(uid);
    }

    /* 系统管理员查询个人信息 */
    @RequestMapping(value = "/admin/{uid}", method = RequestMethod.GET)
    public UserDO queryByUidAdmin(@PathVariable(value = "uid") Integer uid){
        return userService.getByUidAdmin(uid);
    }

    /* 系统管理员查询所有用户 */
    @RequestMapping(value = "/admin/list", method = RequestMethod.GET)
    public List<UserDO> queryAllUsers(){
        return userService.listUsers();
    }
}
