package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);
    // F2 , Option + enter : import
    // shift + enter : 다음칸

    // Command + 1 : 메뉴 왔다갔다
    // Command + n : 생성
    List<Member> findAll();

}
