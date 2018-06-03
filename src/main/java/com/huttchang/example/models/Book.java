package com.huttchang.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.models
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */
@Data
@JsonIgnoreProperties
public class Book {
    // 책 제목
    private String title;
    // 책 저자들
    private String [] authors;
    // 교보문고 바코드 정보
    private String barcode;
    // 카테고리 정보
    @JsonProperty("category")
    private String cat;
    // 책의 내용
    private String contents;
    // 책의 발행일
    private Date datetime;
    // 책의 ISBN정보
    private String isbn;
    // 금액 정보
    private float price;
    // 할인된 금액 정보
    @JsonProperty("sale_price")
    private float salePrice;
    // 책의 이미지
    private String thumbnail;
    // 책 상태(절판...등등)
    private String status;
    // 책의 실제 판매처 링크
    private String url;
    // 출판사
    private String publisher;
}
