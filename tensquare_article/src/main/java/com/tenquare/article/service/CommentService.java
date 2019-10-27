package com.tenquare.article.service;

import com.tenquare.article.dao.CommentDao;
import com.tenquare.article.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

/**
 * @Author ysl
 * @Date 2019/10/27 9:25
 * @Description:
 **/

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;


    public void add(Comment comment){
        comment.set_id(idWorker.nextId()+"");
        commentDao.save(comment);
    }
}
