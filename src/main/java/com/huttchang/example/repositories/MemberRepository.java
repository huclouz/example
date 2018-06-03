package com.huttchang.example.repositories;

import com.huttchang.example.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.repositories
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 3.
 */
public interface MemberRepository extends JpaRepository<Member, Integer>{
    /**
     * 이메일로 사용자를 조회
     * @param email
     * @return
     */
    Member findByEmail(String email);
}
