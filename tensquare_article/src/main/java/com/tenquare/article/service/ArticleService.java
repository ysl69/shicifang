package com.tenquare.article.service;

import com.tenquare.article.dao.ArticleDao;
import com.tenquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @Author ysl
 * @Date 2019/10/26 9:14
 * @Description:
 **/

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Autowired
    private RedisTemplate redisTemplate;


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


    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    public Article findByID(String id){
        //从缓存中提取
        Article article = (Article) redisTemplate.opsForValue().get("article_" + id);
        //如果缓存没有则到数据库查询并放入到缓存
        if (article == null){
            article = articleDao.findById(id).get();
            redisTemplate.opsForValue().set("article_"+id,article,1,TimeUnit.DAYS);
        }
        return article;
    }


    /**
     * 修改
     * @param article
     */
    public void update(Article article){
        redisTemplate.delete("article_"+article.getId());//删除缓存
        articleDao.save(article);
    }


    /**
     * 删除
     * @param id
     */
    public void deleteById(String id){
        redisTemplate.delete("article_"+id);//删除缓存
        articleDao.deleteById(id);
    }
}
