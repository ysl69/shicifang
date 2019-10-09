package com.tenquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @Author ysl
 * @Date 2019/9/20 23:46
 * @Description: 启动类
 **/

@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }


    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
