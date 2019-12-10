package com.tensquare;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ysl
 * @Date 2019/12/10 20:22
 * @Description: token的解析
 **/


public class ParseJwtTest {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJleHAiOjE1NzU5ODEwODd9" +
                ".L0klyIvdKjKmidbrFbWUVM0x7Zo4FoWc-i2qIs2a8f8\n";
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws(token)
                .getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sdf.format(new Date()) );

    }
}
