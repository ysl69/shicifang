package com.tenquare.article.service;

import com.tenquare.article.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ysl
 * @Date 2019/10/26 9:14
 * @Description:
 **/

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;


    /**
     * 文章审核
     * @param id
     */
    public void examine(String id){
        articleDao.examine(id);
    }


    /**
     * 点赞
     * @param id 文章id
     * @return
     */
    @Transactional
    public int updateThumbup(String id){
        return articleDao.updateThumbup(id);
    }
}
