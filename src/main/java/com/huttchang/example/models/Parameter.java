package com.huttchang.example.models;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.models
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */

public abstract class Parameter<K, V> {
    // 파라미터가 저장될 저장소
    private HashMap<K, V> mOptionStorage = new HashMap<>();

    /**
     * 파라미터 추가
     * @param key 파라미터 키
     * @param value 파라미터 밸류
     * @return
     */
    public Parameter addParam(K key, V value) {
        mOptionStorage.put(key, value);
        return this;
    }

    /**
     * 키로 파라미터 조회
     * @param key
     * @return
     */
    public V getParamter(K key) {
        return mOptionStorage.get(key);
    }

    /**
     * add param 된 파라미터를 querysting 형식으로 변경
     */
    public String generateQueryString() {
        String queryString = "";
        for (Map.Entry kvEntry : mOptionStorage.entrySet()) {
            queryString += String.format("&%s=%s", kvEntry.getKey(), kvEntry.getValue());
        }
        return queryString;
    }

}
