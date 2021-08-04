package hello.hellostart.service;

import hello.hellostart.domain.Member;
import hello.hellostart.repository.MemberRepository;
import hello.hellostart.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // test 하기 위해 필요
@Transactional  //  test 끝나면 Rollback을 해준다. -> DB에 Data 반영 X, 다음 test 가능, BeforeEach AfterEach 없어도 된다.
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService; // test 할때는 간편하게 만든다.
    @Autowired
    MemberRepository memberRepository;

    @Test
    //@Commit test 끝나고 DB에 저장시킨다.
    void 회원가입() {
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public  void  중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,() -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }
    @Test
    void findMembers() {
        //given

        //when

        //then
    }

    @Test
    void findOne() {
        //given

        //when

        //then
    }
}