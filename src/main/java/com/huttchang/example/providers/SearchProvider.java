package com.huttchang.example.providers;

import com.huttchang.example.models.Parameter;

import java.util.List;

/**
 * email : huttchang@gmail.com
 * 프로젝트명    : example
 * 작성 및 소유자 : hucloud
 * 최초 생성일   : 2018. 5. 28.
 *
 */
public interface SearchProvider<O extends Parameter, R> {

    List<R> search(O option) throws Exception;

    R detail(String key, String value);

}
