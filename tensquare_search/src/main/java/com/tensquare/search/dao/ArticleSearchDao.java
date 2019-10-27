package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author ysl
 * @Date 2019/10/27 11:11
 * @Description:    文章数据访问层接口
 **/
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {
}
