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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "book_isbn")
    private String bookIsbn;
    @Column(name = "book_title")
    private String bookTitle;
}
