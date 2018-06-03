package com.huttchang.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huttchang.example.models.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.services
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 3.
 */
@Service
public class JWTServiceImpl implements JWTService {

    private String jwtSalt = "JWT_EXAMPLE_FOR_HUTTCHANG";

    public String create(String key, Member m) {
        try {
            return Jwts.builder()
                    .setHeaderParam("sec", "urity")
                    .claim(key,m)
                    .signWith(SignatureAlgorithm.HS256, getJwtSalt()).compact();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isVerify(String jwt) {
        try{
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(getJwtSalt())
                    .parseClaimsJws(jwt);
        }catch (Exception e){
            throw new RuntimeException("Session Expire");
        }
        return true;
    }

    public byte[] getJwtSalt() {
        try{
            return jwtSalt.getBytes("UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Member getJWTData(String key) {
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey(getJwtSalt())
                .parseClaimsJws(key);
        return new ObjectMapper().convertValue(claims.getBody().get("jwt", HashMap.class), Member.class);
    }
}
