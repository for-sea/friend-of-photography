package com.forsea.service;

import com.forsea.pojo.Result;
import com.forsea.pojo.entity.UserDO;
import com.forsea.pojo.vo.UserVO;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: 对user表进行操作
 * @author: 肖四海
 * @create: 2022-05-12 23:23
 **/
public interface UserService {
    void saveUser(UserDO user);

    void removeUser(Integer uid);

    void updateUser(UserVO user);

    void updateUserAdmin(UserDO user);

    UserVO getByUid(Integer uid);

    UserDO getByUidAdmin(Integer uid);

    List<UserDO> listUsers();
}
