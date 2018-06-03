package com.huttchang.example.services;

import com.huttchang.example.models.Member;
import com.huttchang.example.modules.MySqlPasswordEncoder;
import com.huttchang.example.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.services
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 3.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MySqlPasswordEncoder mySqlPasswordEncoder;

    @Override
    public void signup(Member member) {
        member.setPassword(mySqlPasswordEncoder.encode(member.getPassword()));
        memberRepository.save(member);
    }

    @Override
    public Member login(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        member.setPassword(mySqlPasswordEncoder.encode(member.getPassword()));
        if ( !member.getPassword().equals(findMember.getPassword())) {
            findMember.setStatus(Member.MemberStatusCode.AUTH_FAIL.ordinal());
        } else {
            findMember.setStatus(Member.MemberStatusCode.OK.ordinal());
        }
        findMember.setPassword("");
        return findMember;
    }
}
