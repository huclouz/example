package com.huttchang.example.controllers;

import com.huttchang.example.models.Member;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.controllers
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */
@RestController()
@RequestMapping("/members")
public class MemberController {

    /**
     * 회원가입
     * @param member
     */
    @PostMapping("signup")
    public void signUp(Member member) {

    }

    @PostMapping("/login")
    public void login(Member member) {

    }
}
