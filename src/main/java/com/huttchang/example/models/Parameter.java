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

    private HashMap<K, V> mOptionStorage = new HashMap<>();

    public Parameter addParam(K key, V value) {
        mOptionStorage.put(key, value);
        return this;
    }

    public V getParamter(K key) {
        return mOptionStorage.get(key);
    }

    public String generateQueryString() {
        String queryString = "";
        for (Map.Entry kvEntry : mOptionStorage.entrySet()) {
            queryString += String.format("&%s=%s", kvEntry.getKey(), kvEntry.getValue());
        }
        return queryString;
    }

}
