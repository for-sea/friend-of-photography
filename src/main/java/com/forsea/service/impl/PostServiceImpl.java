package com.forsea.service.impl;

import com.forsea.dao.PostDAO;
import com.forsea.pojo.Result;
import com.forsea.pojo.entity.PostDO;
import com.forsea.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: PostService的实现类
 * @author: 肖四海
 * @create: 2022-05-16 12:42
 **/
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostDAO postDAO;

    @Override
    public void savePost(PostDO post) {
        postDAO.insertPost(post);
    }

    @Override
    public void removePost(Integer pid) {
        postDAO.deletePost(pid);
    }

    @Override
    public void updatePost(PostDO post) {
        postDAO.updatePost(post);
    }

    @Override
    public PostDO getByPid(Integer pid) {
        return postDAO.selectByPid(pid);
    }

    @Override
    public List<PostDO> listPosts() {
        return postDAO.selectAllPosts();
    }
}
