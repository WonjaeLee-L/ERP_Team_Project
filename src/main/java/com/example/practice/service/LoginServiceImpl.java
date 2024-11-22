package com.example.practice.service;

import com.example.practice.repository.IF_LoginDao;
import com.example.practice.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class LoginServiceImpl implements IF_LoginService {

    @Autowired
    IF_LoginDao logindao;

    @Override
    public void join(String id, String pass) throws Exception {
        logindao.selectOne(id, pass);
    }

    @Override
    public void signup(MemberVO membervo) throws Exception {
        logindao.insertOne(membervo);
    }
}
