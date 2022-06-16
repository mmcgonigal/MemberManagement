package memberManagement.service;

import memberManagement.domain.Member;

import memberManagement.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class MemberServiceTest {

//    Dependency injection
    MemberService memberService;
    MemoryMemberRepository repository ;

    @BeforeEach
    public void beforeEach() {
        repository= new MemoryMemberRepository();
        memberService= new MemberService(repository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

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
    public void duplicateMemberException() {

        //given
        Member member1 = new Member();
        member1.setName("mina");

        Member member2 = new Member();
        member2.setName("mina");

        //when
//        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("Already existing member");
//
//        }
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("Already existing member");

    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}