package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ysl
 * @Date 2019/10/27 13:39
 * @Description:
 **/

@Service
public class ArticleSearchService {

    @Autowired
    private ArticleSearchDao articleSearchDao;


    /**
     * 增加文章
     * @param article
     */
    public void add(Article article){
        articleSearchDao.save(article);
    }
}
