package com.tensquare.user.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author ysl
 * @Date 2019/12/7 21:10
 * @Description:
 **/

@Service
public class UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 发送短信验证码
     * @param mobile 手机号
     */
    public void  sendSms(String mobile){
        //生成短信验证码
        Random random = new Random();
        int max = 9999;//最大数
        int min = 100000;//最小数
        int code = random.nextInt(max);//随机生成
        if (code<min){
            code = code+min;
        }
        System.out.println(mobile+"收到验证码:"+code);

        //将验证码放入redis
        redisTemplate.opsForValue().set("smscode_"+mobile,code+"",5, TimeUnit.MINUTES);//五分钟后过期

        //将验证码和手机号发送到rabbitMQ中
        Map<String, String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("code",code+"");
        rabbitTemplate.convertAndSend("sms",map);
    }
}
