package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author ysl
 * @Date 2019/12/7 21:18
 * @Description:
 **/

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 发送短信验证码
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/sendSms/{mobile}",method = RequestMethod.POST)
    public Result sendSms(@PathVariable String mobile){
        userService.sendSms(mobile);
        return new Result(true, StatusCode.OK,"发送成功");
    }


    /**
     * 用户注册
     * @param user
     * @param code
     * @return
     */
    @RequestMapping(value = "/register/{code}",method = RequestMethod.POST)
    public Result register(@RequestBody User user,@PathVariable String code){
        userService.add(user,code);
        return new Result(true,StatusCode.OK,"注册成功");
    }


    /**
     * 用户登录
     * @param loginMap
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> loginMap){
        User user = userService.findByMobileAndPassword(loginMap.get("mobile"), loginMap.get("password"
        ));
        if (user!=null){
            return new Result(true,StatusCode.OK,"登录成功");
        }else {
            return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
        }
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        Claims claims = (Claims) request.getAttribute("admin_claims");
        if (claims == null){
            return new Result(true,StatusCode.ACCESSERROR,"无权访问");
        }
        userService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
