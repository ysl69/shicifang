package com.tensquare.qa.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一鉴权拦截器类
 * @author wangxin
 * @version 1.0
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 请求之前进行拦截请求
     * 拦截处理请求得到当前用户信息放入request对象中
     * 经过拦截器后进入控制层代码
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("经过了拦截器");
        final String authHeader = request.getHeader("Authorization");
        if (authHeader!=null && authHeader.startsWith("Bearer ")){
            final String token = authHeader.substring(7);
            Claims claims = jwtUtil.parseJWT(token);
            if (claims != null){
                if ("admin".equals(claims.get("roles"))){
                    //如果是管理员
                    request.setAttribute("admin_claims",claims);
                }
                if ("user".equals(claims.get("roles"))){
                    //如果是用户
                    request.setAttribute("user_claims",claims);
                }
            }
        }

        return true;
    }

}
