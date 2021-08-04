package hello.hellostart.repository;

import hello.hellostart.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // spring bean을 자동으로 생성해서 올린다.

    // 규칙 findByName -> select m from Member m where m.name = ? 을 알아서 생성해준다.
    @Override
    Optional<Member> findByName(String name);
}
