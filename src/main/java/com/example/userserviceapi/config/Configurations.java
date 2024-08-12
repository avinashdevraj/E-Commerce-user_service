package com.example.userserviceapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
public class Configurations {

    @Bean
    public BCryptPasswordEncoder create(){
        return new BCryptPasswordEncoder();
    }
}
