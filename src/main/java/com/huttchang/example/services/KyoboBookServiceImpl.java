package com.huttchang.example.services;

import com.huttchang.example.models.Book;
import com.huttchang.example.models.BookMark;
import com.huttchang.example.models.History;
import com.huttchang.example.models.Parameter;
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
@Deprecated
@Service("KyoboBookService")
public class KyoboBookServiceImpl implements BookService<Parameter, Book> {

    @Resource(name="kyoboAPIProvider")
    SearchProvider kyoboProvider;

    @Override
    public List<Book> search(Parameter option) throws Exception {
        return kyoboProvider.search(option);
    }

    @Override
    public void addBookMark(BookMark book) {

    }

    @Override
    public List<BookMark> findBookMarksByUserId(int userId) {
        return null;
    }

    @Override
    public void deleteBookMark(int bookmarkId) {

    }

    @Override
    public List<History> findHistoryByUserId(int userid) {
        return null;
    }

    @Override
    public void addSearchHistory(History history) {

    }
}
