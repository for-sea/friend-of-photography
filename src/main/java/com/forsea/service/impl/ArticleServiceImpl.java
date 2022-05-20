package com.forsea.service.impl;

import com.forsea.dao.ArticleDAO;
import com.forsea.pojo.Result;
import com.forsea.pojo.entity.ArticleDO;
import com.forsea.pojo.entity.UserDO;
import com.forsea.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: friend-of-photography
 * @description: ArticleService的实现类
 * @author: 肖四海
 * @create: 2022-05-15 22:23
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDAO articleDAO;

    @Override
    public void saveArticle(ArticleDO article) {
        articleDAO.insertArticle(article);
    }

    @Override
    public void removeArticle(Integer aid) {
        articleDAO.deleteArticle(aid);
    }

    @Override
    public void updateArticle(ArticleDO article) {
        articleDAO.updateArticle(article);
    }

    @Override
    public ArticleDO getByAid(Integer aid) {
        return articleDAO.selectByAid(aid);
    }

    @Override
    public List<ArticleDO> listArticles() {
        return articleDAO.selectAllArticles();
    }
}
