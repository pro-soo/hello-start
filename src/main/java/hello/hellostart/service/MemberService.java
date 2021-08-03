package hello.hellostart.service;

import hello.hellostart.domain.Member;
import hello.hellostart.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service -> Java 설정파일 없으면, Annotation 등록 해줘야 동작
public class MemberService {
    //@Autowired    1. 필드 주입 -> 좋은 기능은 X
    private final MemberRepository memberRepository;

    //@Autowired    2. 생성자 주입   -> 권장
    public MemberService(MemberRepository memberRepository) {   // DI
        this.memberRepository = memberRepository;
    }
    // 3. setter 주입 -> 다른 개발자가 코드 접근 가능, 꼬일 수 있다.


    // 회원가입
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원X, Optional이라 가능
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {   // 메소드 따로 빼기, ctrl+alt+shift+ T
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberID){
        return memberRepository.findById(memberID);
    }
}
