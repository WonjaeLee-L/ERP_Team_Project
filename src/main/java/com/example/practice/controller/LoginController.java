package com.example.practice.controller;


import com.example.practice.service.IF_LoginService;
import com.example.practice.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    IF_LoginService loginservice;

    @GetMapping("/")
    public String home() throws Exception{
        return "login";
    }

    @PostMapping("join")
    public String join(@RequestParam("id") String id, @RequestParam("pass") String pass) throws Exception {
//        System.out.println(id);
//        System.out.println(pass);
        loginservice.join(id,pass);
        return "home";
    }

    @PostMapping("signup")
    public String signup(@ModelAttribute MemberVO membervo) throws Exception{
        loginservice.signup(membervo);
        System.out.println("테스트");
        return "login";
    }
}
