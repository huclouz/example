package com.huttchang.example.models;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.models
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 3.
 */
public class KakaoParameter extends Option<String, String> {

    public enum ParameterKey {
        query, sort, size, page, target
    }
}
