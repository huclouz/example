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
    // 마지막페이지 인지 여부
    private boolean isEnd;
    // 총 카운트
    private int totalCount;

    public enum ParameterKey {
        query, // 카카오텍스트
        sort,  // 정렬방식
        size,  // 페이지 사이즈
        page,  // 현재페이지
        target // 카테고리(제목, isbn등등)
    }
}
