package com.tensquare.sms;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Author ysl
 * @Date 2019/12/8 13:59
 * @Description: 短信监听类
 **/

@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String templateCode;//模板编号


    @Value("${aliyun.sms.sign_name}")
    private String signName;//签名

    /**
     * 发送短信
     * @param message
     */
    @RabbitHandler
    public void sendSms(Map<String,String> message){
        System.out.println("手机号:"+message.get("mobile"));
        System.out.println("验证码:"+message.get("code"));

        try {
            smsUtil.sendSms(message.get("monile"),templateCode,signName,"{\"code\":"+ message.get("code") +"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
