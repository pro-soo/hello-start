package hello.hellostart.service;

import hello.hellostart.aop.TimeTraceAop;
import hello.hellostart.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration  // spring Java 설정 파일
public class SpringConfig {
    //private DataSource dataSource;
    //private EntityManager em;

//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired  // jpa Data 사용
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean   // spring bean 등록
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();  // 메모리 -> h2로 변경
        //return new JdbcMemberRepository(dataSource);  // 순수 jdbc
        //return new JdbcTemplateMemberRepository(dataSource);    // template 적용
        //return new JpaMemberRepository(em); // jpa 사용


  //  }

}
