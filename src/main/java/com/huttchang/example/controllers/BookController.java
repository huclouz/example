package com.huttchang.example.controllers;

import com.huttchang.example.models.Book;
import com.huttchang.example.models.BookMark;
import com.huttchang.example.models.KakaoParameter;
import com.huttchang.example.services.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * email : huttchang@gmail.com
 * 프로젝트명    : example
 * 작성 및 소유자 : hucloud
 * 최초 생성일   : 2018. 5. 28.
 */
@CrossOrigin
@RestController()
@RequestMapping("/books")
public class BookController {


    @Resource(name = "KakaoBookService")
    private BookService kakaoService;

    /**
     * 도서 조회
     * @param cat 검색카테고리
     * @param keyword 검색키워드
     * @param pageSize 목록 수량
     * @return
     */
    @GetMapping("cat/{cat}/keyword/{keyword}/size/{itemCount}")
    public List<Book> getBookList(
            @PathVariable String cat, @PathVariable String keyword,
            @PathVariable String itemCount, HttpServletResponse response) {
        try{
            KakaoParameter kakaoBookAPIParameter = new KakaoParameter();
            kakaoBookAPIParameter.addParam(KakaoParameter.ParameterKey.query.name(), URLEncoder.encode(keyword, "utf-8"));
            kakaoBookAPIParameter.addParam(KakaoParameter.ParameterKey.target.name(), cat);
            kakaoBookAPIParameter.addParam(KakaoParameter.ParameterKey.size.name(), itemCount);
            return kakaoService.search(kakaoBookAPIParameter);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 도서 상세 정보 조회
     * @param isbn isbn번호로 도서 조회
     * @return
     */
    @GetMapping("{isbn}")
    public List<Book> getBookDetail(@PathVariable String isbn) {
        try{
            System.out.println("detail : " + isbn);
            KakaoParameter kakaoBookAPIParameter = new KakaoParameter();
            kakaoBookAPIParameter.addParam(KakaoParameter.ParameterKey.query.name(), URLEncoder.encode(isbn, "utf-8"));
            kakaoBookAPIParameter.addParam(KakaoParameter.ParameterKey.target.name(), "isbn");
            kakaoBookAPIParameter.addParam(KakaoParameter.ParameterKey.size.name(), String.valueOf(10));
            return kakaoService.search(kakaoBookAPIParameter);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 북마크 조회
     * @return
     */
    @GetMapping("/marks")
    public List<BookMark> getBookMarks() {
        return kakaoService.findBookMarksByUserId(0);
    }

    /**
     * 북마크 추가
     * @param bookInfo
     * @return
     */
    @PostMapping("/marks")
    public void addBookMarks(BookMark bookInfo) {
        kakaoService.addBookMark(bookInfo);
    }

    /**
     * 북마크 제거
     * @param bookInfo
     * @return
     */
    @DeleteMapping("/marks/{bookmarkId}")
    public void delBookMarks(@PathVariable int bookmarkId) {
        kakaoService.deleteBookMark(bookmarkId);
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
