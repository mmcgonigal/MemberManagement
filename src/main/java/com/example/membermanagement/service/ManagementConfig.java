package com.example.membermanagement.service;

import com.example.membermanagement.repository.MemberRepository;
import com.example.membermanagement.repository.MemoryMemberRepository;
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
