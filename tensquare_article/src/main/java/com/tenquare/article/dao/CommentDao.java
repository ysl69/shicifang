package com.tenquare.article.dao;

import com.tenquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author ysl
 * @Date 2019/10/27 9:23
 * @Description:    评论Dao
 **/
public interface CommentDao extends MongoRepository<Comment,String> {
}
