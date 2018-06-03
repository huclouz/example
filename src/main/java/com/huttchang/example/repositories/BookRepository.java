package com.huttchang.example.repositories;

import com.huttchang.example.models.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.repositories
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 3.
 */
public interface BookRepository extends JpaRepository<BookMark, Integer> {

    List<BookMark> findBookMarksByUserId(int userId);

    void deleteById(int bookmarkId);
}
