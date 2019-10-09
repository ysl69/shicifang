package com.tenquare.base.dao;

import com.tenquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author ysl
 * @Date 2019/9/21 10:25
 * @Description: 标签数据访问接口
 *              JpaRepository提供了基本的增删改查
 *              JpaSpecificationExecutor用于做复杂的条件查询
 **/
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
