package com.example.practice.controller;

import com.example.practice.service.IF_AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final IF_AccountService accountservice;


    @PostMapping("/sayHello")
    public ResponseEntity<String> sayHello(@RequestParam String revenueCode) {
        try {
            String message = String.valueOf(accountservice.selectOne(revenueCode));
            if(message == null || message.isEmpty() || "null".equals(message)) {
                message = "없는 코드를 입력하셨습니다.";
                return ResponseEntity.ok(message);
            }
            return ResponseEntity.ok(message);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("에러가 발생했습니다.");
        }
    }

    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView modelandview) {
        return new ModelAndView();
    }
}