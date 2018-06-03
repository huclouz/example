package com.huttchang.example.models;

import lombok.Data;

import javax.persistence.*;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.models
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 3.
 */
@Data
@Entity
@Table(name = "histories")
public class History {
    // 최근검색 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // 최근검색한 사람의 아이디
    @Column(name = "user_id")
    private int userId;
    // 최근 검색한 검색어
    @Column(name = "search_keyword")
    private String searchKeyword;
    // 검색한 카테고리
    @Column(name = "search_category")
    private String searchCategory;

}
