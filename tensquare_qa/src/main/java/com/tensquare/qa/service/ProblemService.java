package com.tensquare.qa.service;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @Author ysl
 * @Date 2019/10/23 23:44
 * @Description:
 **/

@Service
public class ProblemService {

    @Autowired
    private ProblemDao problemDao;

    /**
     * 根据标签ID查询问题列表
     * @param labelId 标签ID
     * @param page  页码
     * @param size  页大小
     * @return
     */
    public Page<Problem> findNewListByLabelId(String labelId,int page,int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return problemDao.findNewListByLabelId(labelId,pageRequest);
    }
}
