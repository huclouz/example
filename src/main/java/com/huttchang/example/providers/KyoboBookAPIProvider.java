package com.huttchang.example.providers;

import com.huttchang.example.models.Book;
import com.huttchang.example.models.Parameter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.providers
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */
@Component("kyoboAPIProvider")
public class KyoboBookAPIProvider implements SearchProvider<Parameter, Book> {

    @Override
    public List<Book> search(Parameter option) throws Exception {
        System.out.println("Kyobo Search");
        return null;
    }

    @Override
    public Book detail(String key, String value) {
        return null;
    }
}
