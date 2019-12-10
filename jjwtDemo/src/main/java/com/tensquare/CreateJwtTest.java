package com.tensquare;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author ysl
 * @Date 2019/12/10 20:18
 * @Description:
 **/


public class CreateJwtTest {
    public static void main(String[] args) {
        JwtBuilder builder = Jwts.builder()
                .setId("887")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "itcast");
        System.out.println(builder.compact());
    }
}
