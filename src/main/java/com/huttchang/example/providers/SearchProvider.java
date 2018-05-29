package com.huttchang.example.providers;

/**
 * email : huttchang@gmail.com
 * 프로젝트명    : example
 * 작성 및 소유자 : hucloud
 * 최초 생성일   : 2018. 5. 28.
 *
 */
public interface SearchProvider<Option, Response> {
    Response search(Option option) throws Exception;
}
