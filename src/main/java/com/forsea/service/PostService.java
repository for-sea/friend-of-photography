package com.forsea.service;

import com.forsea.pojo.Result;
import com.forsea.pojo.entity.PostDO;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: 对post表进行操作
 * @author: 肖四海
 * @create: 2022-05-16 12:40
 **/
public interface PostService {
    void savePost(PostDO post);

    void removePost(Integer pid);

    void updatePost(PostDO post);

    PostDO getByPid(Integer pid);

    List<PostDO> listPosts();
}
