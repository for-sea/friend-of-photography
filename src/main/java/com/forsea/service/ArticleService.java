package com.forsea.service;

import com.forsea.pojo.entity.ArticleDO;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: 对article表进行操作
 * @author: 肖四海
 * @create: 2022-05-15 22:21
 **/
public interface ArticleService {
    void saveArticle(ArticleDO article);

    void removeArticle(Integer aid);

    void updateArticle(ArticleDO article);

    ArticleDO getByAid(Integer aid);

    List<ArticleDO> listArticles();
}
