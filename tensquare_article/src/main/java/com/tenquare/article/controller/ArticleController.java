package com.tenquare.article.controller;

import com.tenquare.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ysl
 * @Date 2019/10/26 9:16
 * @Description:
 **/

@RestController
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    /**
     * 文章审核
     * @param id
     * @return
     */
    @RequestMapping(value = "examine/{id}",method = RequestMethod.PUT)
    public Result examine(@PathVariable String id){
        articleService.examine(id);
        return new Result(true, StatusCode.OK,"审核成功");
    }

}
