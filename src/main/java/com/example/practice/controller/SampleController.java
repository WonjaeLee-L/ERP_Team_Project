package com.example.practice.controller;

import com.example.practice.service.IF_MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @Autowired
    IF_MemberService memberservice;

    @GetMapping("/")
    public String index() throws Exception {
        memberservice.selectOne("123");
        System.out.println(memberservice.selectOne("123"));
        return "index";
    }
}
