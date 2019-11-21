package com.tensquare.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ysl
 * @Date 2019/11/21 22:45
 * @Description:    消费者
 **/

@Component
@RabbitListener(queues = "itheima")
public class Customer2 {


    @RabbitHandler
    public void showMessage(String message){
        System.out.println("itheima接收到消息："+message);
    }
}
