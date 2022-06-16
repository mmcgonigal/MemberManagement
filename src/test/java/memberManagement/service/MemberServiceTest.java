package memberManagement.service;

import memberManagement.domain.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void join() {
        //given   --- when in this condition , when it is given

        Member member = new Member();
        member.setName("Hello");

        //when    --- when it is executed

        Long saveId = memberService.join(member);

        //then    --- result should be this .
        Member foundMember  = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(foundMember.getName());
    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}