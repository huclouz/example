package com.huttchang.example.models;

import lombok.Data;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.models
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 3.
 */
@Data
public class KakaoParameter extends Parameter<String, String> {

    private boolean isEnd;
    private int totalCount;

    public enum ParameterKey {
        query, sort, size, page, target
    }
}
