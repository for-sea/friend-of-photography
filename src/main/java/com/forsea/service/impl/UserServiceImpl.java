package com.forsea.service.impl;

import com.forsea.dao.UserDAO;
import com.forsea.pojo.Result;
import com.forsea.pojo.entity.UserDO;
import com.forsea.pojo.vo.UserVO;
import com.forsea.pojo.response.UserResponse;
import com.forsea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: UserService的实现类
 * @author: 肖四海
 * @create: 2022-05-12 23:24
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public void saveUser(UserDO user) {
        userDAO.insertUser(user);
    }

    @Override
    public void removeUser(Integer uid) {
        userDAO.deleteUser(uid);
    }

    @Override
    public void updateUser(UserVO user) {
        userDAO.updateUser(user);
    }

    @Override
    public void updateUserAdmin(UserDO user) {
        userDAO.updateUserAdmin(user);
    }

    @Override
    public UserVO getByUid(Integer uid) {
        UserDO userData = userDAO.selectByUid(uid);
        UserVO userVO = new UserVO();

        userVO.setUid(userData.getUid());
        userVO.setUsername(userData.getUsername());
        userVO.setEmail(userData.getEmail());
        userVO.setSex(userData.getSex());
        userVO.setCity(userData.getCity());
        userVO.setPhoto(userData.getPhoto());
        userVO.setJob(userData.getJob());
        userVO.setBirthday(userData.getBirthday());
        userVO.setCreateTime(userData.getCreateTime());
        userVO.setUpdateTime(userData.getUpdateTime());

        return userVO;
    }

    @Override
    public UserDO getByUidAdmin(Integer uid) {
        return userDAO.selectByUid(uid);
    }

    @Override
    public List<UserDO> listUsers() {
        return userDAO.selectAllUsers();
    }
}
