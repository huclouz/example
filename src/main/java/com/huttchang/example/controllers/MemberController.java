package com.huttchang.example.controllers;

import com.huttchang.example.models.Member;
import com.huttchang.example.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.controllers
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */
@CrossOrigin
@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;
    /**
     * 회원가입
     * @param member
     */
    @PostMapping("signup")
    public ResponseEntity<Integer> signUp(Member member) {
        try {
            memberService.signup(member);
            return new ResponseEntity(HttpStatus.OK);
        } catch (DataIntegrityViolationException duplicateException) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public void login(Member member) {

    }
}
