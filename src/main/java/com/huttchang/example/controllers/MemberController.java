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

    /**
     * 로그인
     * @param member (이메일, 비밀번호)
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<Member> login(@RequestBody  Member member, HttpServletRequest request) {
        try {
            // db에서 멤버 조회
            Member loggedMember = memberService.login(member);
            // 멤버가 없다면
            if ( member == null ) {
                // 인증되지 않은 코드 리턴
                return new ResponseEntity<Member>(HttpStatus.UNAUTHORIZED);
            }
            // 인증된 사용자의 상태가 정상적이라면
            if ( loggedMember.getStatus() == Member.MemberStatusCode.OK.ordinal() ) {
                // 토큰을 발행
                String token = jwtService.create("jwt", loggedMember);
                HttpHeaders headers = new HttpHeaders();
                // 헤더에 정보와 함께 Response
                headers.add("Authorization",token);
                return new ResponseEntity<Member>(loggedMember, headers,HttpStatus.OK);
            }
            // 인증에 실패한 경우
            else if ( loggedMember.getStatus() == Member.MemberStatusCode.AUTH_FAIL.ordinal())
                // 인증 실패 코드리턴
                return new ResponseEntity<Member>(HttpStatus.UNAUTHORIZED);
            else if ( loggedMember.getStatus() == Member.MemberStatusCode.LOCK.ordinal())
                // 접근불가 코드 리턴
                return new ResponseEntity<Member>(HttpStatus.FORBIDDEN);
        }catch (Exception e){
            // 다른 얘기치 못한 예외 발생 시 내부서버오류 코드 리턴
            return new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
