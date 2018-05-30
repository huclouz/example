package com.huttchang.example.models;

import lombok.Data;

import java.util.HashMap;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.models
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */
@Data
public abstract class Option {

    private HashMap<String, ?> mOptionStorage = new HashMap<>();

    public abstract Option addParam();

}
