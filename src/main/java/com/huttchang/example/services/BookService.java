package com.huttchang.example.services;

import com.huttchang.example.providers.SearchProvider;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.services
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */
public interface BookService<O, R> {

    List<R> search(O option) throws Exception;

    R detail(String key, String value);


}
