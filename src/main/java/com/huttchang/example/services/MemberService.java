package com.huttchang.example.services;

import com.huttchang.example.models.Member;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.services
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 3.
 */
public interface MemberService {

    void signup(Member member);

    Member login(Member member);
}
