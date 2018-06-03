package com.huttchang.example.services;

import com.huttchang.example.models.Book;
import com.huttchang.example.models.BookMark;
import com.huttchang.example.models.Parameter;
import com.huttchang.example.providers.SearchProvider;
import com.huttchang.example.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class KakaoBookServiceImpl implements BookService<Parameter, Book> {

    @Resource(name="kakaoAPIProvider")
    private SearchProvider kakaoProvider;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> search(Parameter option) throws Exception {
        // save history
        return kakaoProvider.search(option);
    }

    @Override
    public void addBookMark(BookMark bookMark) {
        bookRepository.save(bookMark);
    }

    @Override
    public void deleteBookMark(int bookmarkId) {
        bookRepository.deleteById(bookmarkId);
    }

    @Override
    public List<BookMark> findBookMarksByUserId(int userId) {
        return bookRepository.findBookMarksByUserId(userId);
    }
}
