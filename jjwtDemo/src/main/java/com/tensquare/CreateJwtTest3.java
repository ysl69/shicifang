package com.tensquare;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author ysl
 * @Date 2019/12/10 20:32
 * @Description: 自定义claims
 **/


public class CreateJwtTest3 {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();//当前时间
        long exp = now + 1000*60;//过期时间为1分钟
        JwtBuilder builder= Jwts.builder().setId("888")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"itcast")
                .setExpiration(new Date(exp))
                .claim("roles","admin")
                .claim("logo","logo.png");
        System.out.println( builder.compact() );
    }
}
