package com.tensquare.friend.controller;

import com.tensquare.friend.service.FriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ysl
 * @Date 2019/12/13 23:08
 * @Description:
 **/

@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @Autowired
    private HttpServletRequest request;


    /**
     * 添加好友
     * @param friendid 对方用户ID
     * @param type  1:喜欢    0：不喜欢
     * @return
     */
    @RequestMapping(value = "/like/{friendid}/{type}",method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid,@PathVariable String type){
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null){
            return new Result(false, StatusCode.ACCESSERROR,"无权访问");
        }
        //如果喜欢
        if (type.equals("1")){
            if (friendService.addFriend(claims.getId(),friendid)==0){
                return new Result(false,StatusCode.REPERROR,"已经添加次好友");
            }
        }else {
            //不喜欢
        }
        return new Result(true,StatusCode.OK,"操作成功");
    }
}
