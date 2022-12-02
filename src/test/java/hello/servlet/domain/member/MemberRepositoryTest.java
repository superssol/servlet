package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
//        Member member = new Member();
//        member.setUsername("임한솔");
//        member.setAge(29);
        Member member = new Member("임한솔", 29);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(member.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

//    @Test
//    void findById() {
//    }
//
    @Test
    void findAll() {

        //given
        Member member1 = new Member("사람1", 20);
        Member member2 = new Member("사람2", 22);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> allMembers = memberRepository.findAll();
        //then - 갯수하고, 멤버를 증명
        assertThat(allMembers.size()).isEqualTo(2);
        assertThat(allMembers).contains(member1, member2);

    }
//
//    @Test
//    void clearStore() {
//    }
}