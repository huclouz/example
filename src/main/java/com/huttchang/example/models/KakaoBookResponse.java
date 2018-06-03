package com.huttchang.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.models
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 1.
 */
@Data
public class KakaoBookResponse {
    // 카카오에서 정의한 데이터 필드
    private List<Book> documents;
    // 카카오에서 정의한 페이지메타 정보
    private MetaData meta;

    @Data
    public class MetaData {
        // 총 카운트
        @JsonProperty("total_count")
        private int totalCount;
        // 사용가능한 카운트
        @JsonProperty("pageable_count")
        private int pageableCount;
        // 마지막페이지 여부
        @JsonProperty("is_end")
        private boolean isEnd;
    }
}
