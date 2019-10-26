package com.tenquare.article.dao;

import com.tenquare.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author ysl
 * @Date 2019/10/26 9:06
 * @Description: 数据访问接口
 **/
public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {


    /**
     * 审核
     * @param id
     */
    @Modifying
    @Query("update Article set state='1' where id=?1")
    public void examine(String id);
}
