package com.xenon.hrs.tool;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.gson.io.GsonSerializer;

import java.util.Date;

public class JwtUtils
{
    // 7天过期，单位为秒
    private static final long expire = 604800;

    // 生成Token的密匙，这里设置为64位
    private static final String secret = "abcd1234abcd1234abcd1234abcd1234abcd1234abcd1234abcd1234abcd1234";

    // 生成Token
    public static String getToken(String userName)
    {
        // 设置时间及生命周期
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 2 * expire);
        return Jwts.builder()
                .setHeaderParam("Type", "JWT")
                .setSubject(userName)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .serializeToJsonWith(new GsonSerializer<>(new Gson()))
                .compact();

    }

    // 解析Token
    public static Claims getClaims(String token)
    {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

    }
}
