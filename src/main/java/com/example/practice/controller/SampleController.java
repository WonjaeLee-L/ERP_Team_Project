package com.example.practice.controller;

import com.example.practice.service.IF_MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class SampleController {

    private final IF_MemberService memberservice;

    @GetMapping
    public ModelAndView index() throws Exception {
        memberservice.selectOne("chan");
        System.out.println(memberservice.selectOne("chan"));
        ModelAndView mv = new ModelAndView("account");
        return mv;
    }
}




