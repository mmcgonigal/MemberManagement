package com.example.membermanagement;

import memberManagement.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagementConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService();
    }
}
