package memberManagement.service;

import memberManagement.domain.Member;
import memberManagement.repository.MemberRepository;
import memberManagement.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }




//    enrollment

    public Long join(Member member) {
//        duplicated name can not be joined .


//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m ->{
//            throw new IllegalStateException( "Already existing member") ;
//        });

         validateDuplicateMember(member);  // validating duplicate member

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m ->{
                            throw new IllegalStateException("Already existing member");
                        });
    }


//    Check, find  all members.
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }





}
