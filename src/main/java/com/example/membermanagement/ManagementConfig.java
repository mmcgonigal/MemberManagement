package com.example.membermanagement;

import memberManagement.repository.MemberRepository;
import memberManagement.repository.MemoryMemberRepository;
import memberManagement.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagementConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository() );
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }







}
