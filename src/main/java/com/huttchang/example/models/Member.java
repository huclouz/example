package com.huttchang.example.models;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String name;
    private String password;

    @Column(name = "is_verify")
    private int status;

    @Column(name = "crt_date")
    private Date createDate;

    public enum MemberStatusCode {
        AUTH_FAIL, LOCK, OK
    }

}
