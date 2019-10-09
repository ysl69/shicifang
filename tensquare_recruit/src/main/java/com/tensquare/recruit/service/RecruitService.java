package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ysl
 * @Date 2019/9/22 9:55
 * @Description:
 **/

@Service
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;


    /**
     * 根据状态码查询
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state){
        return recruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }


    /**
     * 最新职位列表
     * @return
     */
    public List<Recruit> newlist(){
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc("0");
    }
}
