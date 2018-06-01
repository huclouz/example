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

    private String title;
    private String [] authors;
    private String barcode;

    @JsonProperty("category")
    private String cat;
    private String contents;
    private Date datetime;
    private String isbn;
    private float price;
    @JsonProperty("sale_price")
    private float salePrice;

}
