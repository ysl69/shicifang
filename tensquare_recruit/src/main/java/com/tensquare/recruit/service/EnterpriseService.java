package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @Author ysl
 * @Date 2019/9/21 19:58
 * @Description:
 **/

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 热门企业列表
     * @return
     */
    public List<Enterprise> hoslist(){
        return enterpriseDao.findByIshot("1");
    }
}
