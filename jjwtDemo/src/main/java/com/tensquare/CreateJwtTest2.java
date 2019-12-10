package com.tensquare;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author ysl
 * @Date 2019/12/10 20:25
 * @Description: token过期校验
 **/


public class CreateJwtTest2 {
    public static void main(String[] args) {
        //当前时间
        long now = System.currentTimeMillis();
        //过期时间为1分钟
        long exp = now + 1000 * 60;
        JwtBuilder builder = Jwts.builder()
                .setId("888")
                .setSubject("小白")
                .signWith(SignatureAlgorithm.HS256, "itcast")
                .setExpiration(new Date(exp));
        System.out.println(builder.compact());
    }
}
