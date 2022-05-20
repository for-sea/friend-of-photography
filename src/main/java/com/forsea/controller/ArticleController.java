package com.forsea.controller;

import com.forsea.pojo.entity.ArticleDO;
import com.forsea.service.impl.ArticleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: 版块管理模块接口
 * @author: 肖四海
 * @create: 2022-05-15 22:27
 **/
@Slf4j
@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;

    /* 添加文章 */
    @RequestMapping(method = RequestMethod.POST)
    public void addArticle(@Validated @RequestBody ArticleDO article){
        articleService.saveArticle(article);
    }

    /* 根据aid删除文章 */
    @RequestMapping(value = "/{aid}", method = RequestMethod.DELETE)
    public void deleteArticle(@PathVariable(value = "aid") Integer aid){
        articleService.removeArticle(aid);
    }

    /* 更新文章信息 */
    @RequestMapping(method = RequestMethod.PUT)
    public void modifyArticle(@Validated @RequestBody ArticleDO article){
        articleService.updateArticle(article);
    }

    /* 查询文章信息 */
    @RequestMapping(value = "/{aid}", method = RequestMethod.GET)
    public ArticleDO queryByAid(@PathVariable(value = "aid") Integer aid){
        return articleService.getByAid(aid);
    }

    /* 查询所有文章 */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<ArticleDO> queryAllArticles(){
        return articleService.listArticles();
    }
}
