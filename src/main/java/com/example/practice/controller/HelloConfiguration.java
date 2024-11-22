package com.example.practice.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class HelloConfiguration {

    @Bean
    public ModelAndView model() {
        return new ModelAndView();
    }
}
