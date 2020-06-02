package com.management.issuemanagement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IssueManagementConfig {

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }
}
