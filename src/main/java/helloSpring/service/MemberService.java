package helloSpring.service;

import helloSpring.domain.Member;
import helloSpring.repository.MemberRepository;
import helloSpring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

//    enrollment

    public Long join(Member member) {
//        duplicated name can not be joined .


//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m ->{
//            throw new IllegalStateException( "Already existing member") ;
//        });

        memberRepository.findByName(member.getName())
                        .ifPresent(m ->{
                            throw new IllegalStateException("Already existing member");
                        });


        memberRepository.save(member);
        return member.getId();
    }

}
