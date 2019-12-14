package com.tensquare.user.service;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.Date;
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

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

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


    /**
     * 增加
     * @param user 用户
     * @param code 用户填写的验证码
     */
    public void add(User user,String code){
        //判断验证码是否正确
        String syscode = (String) redisTemplate.opsForValue().get("smscode" + user.getMobile());
        //提取系统正确的验证码
        if (syscode == null){
            throw new RuntimeException("请点击获取短信验证码");
        }
        if (!syscode.equals(code)){
            throw new RuntimeException("验证码输入不正确");
        }
        user.setId(idWorker.nextId()+"");
        user.setFollowcount(0);//关注数
        user.setFanscount(0);//粉丝数
        user.setOnline(0L);//在线时长
        user.setRegdate(new Date());//注册日期
        user.setUpdatedate(new Date());//更新日期
        user.setLastdate(new Date());//最后登录日期

        //密码加密
        String newpassword = encoder.encode(user.getPassword());
        user.setPassword(newpassword);

        userDao.save(user);
    }


    /**
     * 根据手机号和密码查询用户
     * @param mobile
     * @param password
     * @return
     */
    public User findByMobileAndPassword(String mobile,String password){
        User user = userDao.findByMobile(mobile);
        if (user!=null && encoder.matches(password,user.getPassword())){
            return user;
        }else {
            return null;
        }
    }


    /**
     * 删除
     * @param id
     */
    public void deleteById(String id) {
        userDao.deleteById(id);
    }


    /**
     * 更新粉丝数
     * @param userid
     * @param x
     */
    @Transactional
    public void incFanscount(String userid,int x){
        userDao.incFanscount(userid,x);
    }
}
