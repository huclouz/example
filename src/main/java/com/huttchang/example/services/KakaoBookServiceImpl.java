package com.huttchang.example.services;

import com.huttchang.example.models.*;
import com.huttchang.example.providers.SearchProvider;
import com.huttchang.example.repositories.BookRepository;
import com.huttchang.example.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
public class KakaoBookServiceImpl implements BookService<KakaoParameter, Book> {

    @Resource(name="kakaoAPIProvider")
    private SearchProvider kakaoProvider;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public List<Book> search(KakaoParameter option) throws Exception {
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

    @Override
    public void addSearchHistory(History history) {
        historyRepository.save(history);
    }

    @Override
    public List<History> findHistoryByUserId(int userId) {
        return historyRepository.findByUserId(userId, new Sort(Sort.Direction.DESC, "id"));
    }

}
