package com.tensquare.user.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一鉴权拦截器类
 * @author wangxin
 * @version 1.0
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    /**
     * 请求之前进行拦截请求
     * 拦截处理请求得到当前用户信息放入request对象中
     * 经过拦截器后进入控制层代码
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器被访问了.....");
        return true;
    }

}
