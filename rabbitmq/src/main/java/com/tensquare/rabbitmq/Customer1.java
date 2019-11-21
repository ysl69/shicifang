package com.tensquare.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ysl
 * @Date 2019/11/21 22:42
 * @Description:    消费者
 **/


@Component
@RabbitListener(queues = "itcast")
public class Customer1 {


    @RabbitHandler
    public void showMessage(String message){
        System.out.println("itcast接收到消息："+message);
    }
}
