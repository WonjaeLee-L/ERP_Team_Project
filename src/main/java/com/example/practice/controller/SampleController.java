package com.example.practice.controller;

import com.example.practice.service.IF_MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/index")
@RequiredArgsConstructor
public class SampleController {

    private final IF_MemberService memberservice;

    @GetMapping
    public ModelAndView index() throws Exception {
        memberservice.selectOne("chan");
        System.out.println(memberservice.selectOne("chan"));
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}




