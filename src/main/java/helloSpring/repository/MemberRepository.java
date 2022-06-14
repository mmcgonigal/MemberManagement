package helloSpring.repository;


import helloSpring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findbyId(Long id);
    Optional<Member> findbyname(String name);
    List<Member> findAll();


}
