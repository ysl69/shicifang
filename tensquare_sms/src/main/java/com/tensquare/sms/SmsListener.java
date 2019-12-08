package com.tensquare.sms;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author ysl
 * @Date 2019/12/8 13:59
 * @Description: 短信监听类
 **/

@Component
@RabbitListener(queues = "sms")
public class SmsListener {


    /**
     * 发送短信
     * @param message
     */
    @RabbitHandler
    public void sendSms(Map<String,String> message){
        System.out.println("手机号:"+message.get("mobile"));
        System.out.println("验证码:"+message.get("code"));
    }
}
