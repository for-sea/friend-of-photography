package com.forsea.controller;

import com.forsea.pojo.Result;
import com.forsea.pojo.entity.PostDO;
import com.forsea.service.impl.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: 发布帖子模块接口
 * @author: 肖四海
 * @create: 2022-05-10 12:11
 **/
@Slf4j
@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    /* 添加帖子 */
    @RequestMapping(method = RequestMethod.POST)
    public void addPost(@Validated @RequestBody PostDO post){
        postService.savePost(post);
    }

    /* 根据pid删除帖子 */
    @RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable(value = "pid") Integer pid){
        postService.removePost(pid);
    }

    /* 更新帖子信息 */
    @RequestMapping(method = RequestMethod.PUT)
    public void modifyPost(@Validated @RequestBody PostDO post){
        postService.updatePost(post);
    }

    /* 查询帖子信息 */
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public PostDO queryByPid(@PathVariable(value = "pid") Integer pid){
        return postService.getByPid(pid);
    }

    /* 查询所有帖子 */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<PostDO> queryAllPosts(){
        return postService.listPosts();
    }
}
