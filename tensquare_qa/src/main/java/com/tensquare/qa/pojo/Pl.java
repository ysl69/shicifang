package com.tensquare.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author ysl
 * @Date 2019/10/23 23:33
 * @Description:    中间表 tb_pl  问题和标签中间表
 *                  problemid+labelid ==> 联合主键
 **/

@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable {

    @Id
    private String problemid;

    @Id
    private String labelid;

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }
}
