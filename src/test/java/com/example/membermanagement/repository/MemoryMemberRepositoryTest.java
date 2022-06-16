package com.example.membermanagement.repository;

import helloSpring.domain.Member;
import helloSpring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("SpringTest");
        repository.save(member);

        Member result = repository.findbyId(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }


}
