package com.example.practice.service;

import com.example.practice.repository.IF_MemberDao;
import com.example.practice.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    // 해당 클래스를 객체로 만들어라..
public class MemberServiceImpl implements IF_MemberService{
	@Autowired
	IF_MemberDao memberdao;
	@Override
	public void join(MemberVO membervo) throws Exception {
		System.out.println("join 서비스");
		// 아이디 검사 등 중복체크 할 수 있다.. <생략>
		// dao에게 작업 지시해야 한다... 
		// 실제 데이터를 저장하도록 지시한다...
		memberdao.insertOne(membervo);
	}
	@Override
	public MemberVO selectOne(String id) throws Exception {
		// TODO Auto-generated method stub
		return memberdao.selectOne(id);
	}

}
