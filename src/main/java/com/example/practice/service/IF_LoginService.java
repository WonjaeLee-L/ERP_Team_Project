package com.example.practice.service;

import com.example.practice.vo.MemberVO;

public interface IF_LoginService {
    public void join(String id, String pass) throws Exception;
    public void signup(MemberVO membervo) throws Exception;
}
