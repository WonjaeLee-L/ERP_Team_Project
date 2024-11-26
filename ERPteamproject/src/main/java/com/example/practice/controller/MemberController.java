package com.example.practice.controller;


import com.example.practice.service.IF_MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @Autowired
    IF_MemberService memberservice;

    @GetMapping("list")
    public String list(){
        return "member/list";
    }
}
