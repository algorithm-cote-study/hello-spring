package com.hello.hellospring.service;


import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    // service 명확하게 뭘할지 정해져있으면 interface 안만들어줘도됨
    // interface 서비스 하나에 단일 기능

    // final 불변: 
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     * javadoc -> Controller
     *
     * @param member
     * @return
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 안됨
        // command + option + v : 변수 이름 추출하기
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // orElse 없으면
        // ifPresent 있으면
        Optional<Member> byName = memberRepository.findByName(member.getName());
        byName
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     *
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
