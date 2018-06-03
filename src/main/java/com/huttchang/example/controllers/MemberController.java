package com.huttchang.example.controllers;

import com.huttchang.example.models.Member;
import com.huttchang.example.services.JWTService;
import com.huttchang.example.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

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

    @Autowired
    private JWTService jwtService;
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
    public ResponseEntity<Member> login(@RequestBody  Member member, HttpServletRequest request) {
        try {
            Enumeration<String> header = request.getHeaderNames();
            while ( header.hasMoreElements()) {
                String name = header.nextElement();
                System.out.println(String.format("%s=%s", name, request.getHeader(name)) );
            }

            Member loggedMember = memberService.login(member);
            if ( member == null ) {
                return new ResponseEntity<Member>(HttpStatus.UNAUTHORIZED);
            }
            if ( loggedMember.getStatus() == Member.MemberStatusCode.OK.ordinal() ) {
                String token = jwtService.create("jwt", loggedMember);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization",token);
                return new ResponseEntity<Member>(loggedMember, headers,HttpStatus.OK);
            }
            else if ( loggedMember.getStatus() == Member.MemberStatusCode.AUTH_FAIL.ordinal())
                return new ResponseEntity<Member>(HttpStatus.UNAUTHORIZED);
            else if ( loggedMember.getStatus() == Member.MemberStatusCode.LOCK.ordinal())
                return new ResponseEntity<Member>(HttpStatus.FORBIDDEN);
        }catch (Exception e){
            return new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
