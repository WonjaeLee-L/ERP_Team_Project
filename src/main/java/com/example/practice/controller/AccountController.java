package com.example.practice.controller;

import com.example.practice.service.IF_AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/index")
@RequiredArgsConstructor
public class AccountController {

    private final IF_AccountService accountservice;

    @GetMapping
    public ModelAndView index() throws Exception {
        accountservice.selectAll();
        System.out.println(accountservice.selectAll());
        System.out.println(accountservice.selectOne("1110"));
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

}
