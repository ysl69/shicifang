package com.tensquare.qa.client.impl;

import com.tensquare.qa.client.LabelClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @Author ysl
 * @Date 2019/12/17 20:44
 * @Description:
 **/

@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.ERROR,"熔断器启动了");
    }
}
