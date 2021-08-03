package hello.hellostart.service;

import hello.hellostart.repository.MemberRepository;
import hello.hellostart.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // spring Java 설정 파일
public class SpringConfig {

    @Bean   // spring bean 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
