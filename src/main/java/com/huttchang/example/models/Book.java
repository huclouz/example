package com.huttchang.example.models;

import lombok.Data;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.models
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */
@Data
public class Book {


    private String name;
    private String writer;

    public Book(String name, String writer) {
        this.name = name;
        this.writer = writer;
    }
}
