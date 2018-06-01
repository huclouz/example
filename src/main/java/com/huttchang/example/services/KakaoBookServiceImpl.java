package com.huttchang.example.services;

import com.huttchang.example.models.Book;
import com.huttchang.example.models.Option;
import com.huttchang.example.providers.SearchProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.services
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */
@Service("KakaoBookService")
public class KakaoBookServiceImpl implements BookService<Option, Book> {

    @Resource(name="kakaoAPIProvider")
    private SearchProvider kakaoProvider;

    @Override
    public List<Book> search(Option option) throws Exception {
        // save history
        return kakaoProvider.search(option);
    }

    @Override
    public Book detail(String key, String value) {
        return null;
    }
}
