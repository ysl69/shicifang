package com.tensquare;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @Author ysl
 * @Date 2019/12/10 20:22
 * @Description: token的解析
 **/


public class ParseJwtTest {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODciLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NzU5ODA0NTl9" +
                ".MgM7prRUDsygpN6QzFpoP4-SeRNTptkyRtygYNZN04s";
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws(token)
                .getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("IssuedAt:"+claims.getIssuedAt());

    }
}
