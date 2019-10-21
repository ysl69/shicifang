package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ysl
 * @Date 2019/9/22 10:13
 * @Description:
 **/

@RestController
@RequestMapping(value = "/recruit")
public class RecruitController {


    @Autowired
    private RecruitService recruitService;


    /**
     * 推荐职位列表
     * @return
     */
    @RequestMapping(value = "/search/recommend",method = RequestMethod.GET)
    public Result recommend(){
        List<Recruit> list = recruitService.findTop4ByStateOrderByCreatetimeDesc("2");
        return new Result(true, StatusCode.OK,"查询成功",list);
    }


    /**
     * 最新职位列表
     * @return
     */
    @RequestMapping(value = "/search/newlist",method = RequestMethod.GET)
    public Result newlist(){
        return new Result(true,StatusCode.OK,"查询成功",recruitService.newlist());
    }
}
