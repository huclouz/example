package com.huttchang.example.controllers;

import com.huttchang.example.models.Book;
import com.huttchang.example.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * email : huttchang@gmail.com
 * 프로젝트명    : example
 * 작성 및 소유자 : hucloud
 * 최초 생성일   : 2018. 5. 28.
 */

@RestController()
@RequestMapping("/books")
public class BookController {


    @Resource(name = "KakaoBookService")
    private BookService kakaoService;

    @Resource(name = "KyoboBookService")
    private BookService kyoboService;

    /**
     * 도서 조회
     * @param cat 검색카테고리
     * @param keyword 검색키워드
     * @return
     */
    @GetMapping
    public List<Book> getBookList(String cat, String keyword, HttpServletResponse response) {
        try{
            kakaoService.search(null);
        }catch (Exception e){

        }
        return null;
    }

    @GetMapping("/kyobo")
    public List<Book> getBookListByKyoboAPI(String cat, String keyword, HttpServletResponse response) {

        try{
            kyoboService.search(null);
        }catch (Exception e){

        }
        return null;
    }

    /**
     * 도서 상세 정보 조회
     * @param isbn isbn번호로 도서 조회
     * @return
     */
    @GetMapping("/{isbn}")
    public Book getBookList(@PathVariable("isbn") String isbn) {
        return null;
    }

    /**
     * 검색히스토리 조회
     * @return
     */
    @GetMapping("/histories")
    public List<Book> getHistoryList() {
        return null;
    }

}
