package com.huttchang.example.services;

import com.huttchang.example.models.Member;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.services
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 3.
 */
public interface JWTService {

    String create(String key, Member m);

    boolean isVerify(String jwt);

    byte[] getJwtSalt();

    Member getJWTData(String key);

}
