package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author ysl
 * @Date 2019/9/22 10:52
 * @Description:
 **/
public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {


    /**
     * 根据标签ID查询最新问题列表
     * @param labelId
     * @param pageable
     * @return
     * @Query 使用jpql的方式查询。?1代表参数的占位符，其中1对应方法中的参数索引
     */
    @Query("select p from Problem p where id in( select problemid from Pl where labelid=?1 ) order by replytime desc")
    public Page<Problem> findNewListByLabelId(String labelId, Pageable pageable);



    /**
     * 根据标签ID查询热门问题列表
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in(select peoblemid from pl where labelid=?1) order by reply desc ")
    public Page<Problem> findHotListByLabelId(String labelId, Pageable pageable);
}
