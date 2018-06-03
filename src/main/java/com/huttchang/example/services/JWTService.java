package com.huttchang.example.services;

import com.huttchang.example.models.Member;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.services
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 3.
 */
public interface JWTService {
    // jwt 토큰 생성
    String create(String key, Member m);
    // 토큰유효성 검사
    boolean isVerify(String jwt);
    // JWT Salt 조회
    byte[] getJwtSalt();
    // jwt멤버 조회
    Member getJWTData(String key);

}
