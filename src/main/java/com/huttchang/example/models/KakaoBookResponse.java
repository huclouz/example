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

    private List<Book> documents;
    private MetaData meta;

    @Data
    public class MetaData {
        @JsonProperty("total_count")
        private int totalCount;

        @JsonProperty("pageable_count")
        private int pageableCount;

        @JsonProperty("is_end")
        private boolean isEnd;
    }
}
