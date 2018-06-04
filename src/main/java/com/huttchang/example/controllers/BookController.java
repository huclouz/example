package com.huttchang.example.controllers;

import com.huttchang.example.models.*;
import com.huttchang.example.services.BookService;
import com.huttchang.example.services.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URLEncoder;
import java.util.List;

/**
 * email : huttchang@gmail.com
 * 프로젝트명    : example
 * 작성 및 소유자 : hucloud
 * 최초 생성일   : 2018. 5. 28.
 */
@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {

    @Resource(name = "KakaoBookService")
    private BookService kakaoService;

    @Autowired
    private JWTService jwtService;

    /**
     * 도서 목록 조회
     * @param cat 카테고리
     * @param keyword 검색어
     * @param itemCount 아이템 조회 수
     * @param pageNo 현재 페이지 번호
     * @param model Response할 모델데이터
     * @param token 토큰이 있는 경우의 토큰데이터(header)
     * @return 도서정보
     */
    @GetMapping("cat/{cat}/keyword/{keyword}/size/{itemCount}/page/{pageNo}")
    public ResponseEntity<Model> getBookList(
            @PathVariable String cat, @PathVariable String keyword,
            @PathVariable String itemCount, @PathVariable String pageNo, Model model,
            @RequestHeader(name = "Authorization", required = false) String token) {
        try{
            KakaoParameter kakaoBookAPIParameter = new KakaoParameter();
            kakaoBookAPIParameter.addParam(KakaoParameter.ParameterKey.query.name(), URLEncoder.encode(keyword, "utf-8"));
            kakaoBookAPIParameter.addParam(KakaoParameter.ParameterKey.target.name(), cat);
            kakaoBookAPIParameter.addParam(KakaoParameter.ParameterKey.size.name(), itemCount);
            kakaoBookAPIParameter.addParam(KakaoParameter.ParameterKey.page.name(), pageNo);

            model.addAttribute("data", kakaoService.search(kakaoBookAPIParameter));
            model.addAttribute("isEnd", kakaoBookAPIParameter.isEnd());
            model.addAttribute("totalCount", kakaoBookAPIParameter.getTotalCount());
            model.addAttribute("keyword", keyword);
            return new ResponseEntity<Model>(model, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 인증정보가 있다면 히스토리 추가
            try {
                if (token!=null) {
                    System.out.println(token);
                    Member member = jwtService.getJWTData(token);
                    History his = new History();
                    his.setSearchCategory(cat);
                    his.setSearchKeyword(keyword);
                    his.setUserId(member.getId());
                    kakaoService.addSearchHistory(his);
                }
            }catch (DataIntegrityViolationException e){

            }

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
    public List<BookMark> getBookMarks(@RequestHeader(name = "Authorization", required = false) String token) {
        if ( token != null ) {
            Member member = jwtService.getJWTData(token);
            return kakaoService.findBookMarksByUserId(member.getId());
        }
        return null;
    }

    /**
     * 북마크 추가
     * @param bookInfo
     * @return
     */
    @PostMapping("/marks")
    public void addBookMarks(BookMark bookInfo, @RequestHeader(name = "Authorization", required = false) String token) {
        if ( token != null ) {
            bookInfo.setUserId(jwtService.getJWTData(token).getId());
            kakaoService.addBookMark(bookInfo);
        }
    }

    /**
     * 북마크의 번호를 이용하여 북마크 제거
     * @param bookmarkId 북마크의 식별자
     */
    @DeleteMapping("/marks/{bookmarkId}")
    public void delBookMarks(@PathVariable int bookmarkId) {
        kakaoService.deleteBookMark(bookmarkId);
    }


    /**
     * 검색 히스토리 조회
     * @param token 토큰이 있는 경우에만 수행
     * @return
     */
    @GetMapping("/histories")
    public List<Book> getHistoryList(@RequestHeader(name = "Authorization", required = false) String token) {
        if ( token != null ) {
            return kakaoService.findHistoryByUserId(jwtService.getJWTData(token).getId());
        }
        return null;
    }

}
