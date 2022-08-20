package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// command + shift + t : test파일 생성
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    // ctrl + shift + r
    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        // Optional<> : .get()
        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result);
        // sout : system.out.println
        System.out.println("result = " + result);
        System.out.println("result = " + (result == member));
    }
    // command + shift + 방향키
    // command + option + 방향키 : 위아래 움직이기
    @Test
    void findByName() {
        // Option + command + v
        // shift + F6 : 변수명 바꾸기
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // command + d : 블럭 복붙
        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findById() {
    }

}