package com.tenquare.article.dao;

import com.tenquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author ysl
 * @Date 2019/10/27 9:23
 * @Description:    评论Dao
 **/
public interface CommentDao extends MongoRepository<Comment,String> {


    /**
     * 根据文章ID查询评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid);
}
