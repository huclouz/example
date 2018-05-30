package com.huttchang.example.providers;

import com.huttchang.example.models.Book;
import com.huttchang.example.models.Option;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.providers
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */
@Repository("kyoboAPIProvider")
public class KyoboBookAPIProvider implements SearchProvider<Option, Book> {

    @Override
    public List<Book> search(Option option) throws Exception {
        System.out.println("Kyobo Search");
        return null;
    }

    @Override
    public Book detail(String key, String value) {
        return null;
    }
}
