package com.huttchang.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.models
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 28.
 */

@Data
@Entity
@Table(name = "users")
public class Member {
    // 사용자 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // 사용자 이메일
    private String email;
    // 사용자 이름
    private String name;
    // 사용자 비밀번호
    private String password;
    // 사용자의 상태
    @Column(name = "is_verify")
    private int status;
    // 가입일자
    @Column(name = "crt_date")
    private Date createDate;
    // 사용자의 토큰
    @Transient
    private String token;
    // 상태 코드
    public enum MemberStatusCode {
        AUTH_FAIL, LOCK, OK
    }

}
