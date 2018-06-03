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
@Table(name = "bookmarks")
public class BookMark {
    // 북마크 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // 사용자 번호
    @Column(name = "user_id")
    private int userId;
    // 북마크한 ISBN번호
    @Column(name = "book_isbn")
    private String bookIsbn;
    // 북마크한 책 제목
    @Column(name = "book_title")
    private String bookTitle;
}
