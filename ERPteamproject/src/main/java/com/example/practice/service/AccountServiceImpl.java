package com.example.practice.service;

import com.example.practice.repository.IF_AccountDao;
import com.example.practice.vo.RevenueVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service    // 해당 클래스를 객체로 만들어라..
@RequiredArgsConstructor
public class AccountServiceImpl implements IF_AccountService{

	private final IF_AccountDao adao;

	@Override
	public void join(RevenueVO rvo) throws Exception {
		System.out.println("join 서비스");
		// 아이디 검사 등 중복체크 할 수 있다.. <생략>
		// dao에게 작업 지시해야 한다... 
		// 실제 데이터를 저장하도록 지시한다...
		adao.insertOne(rvo);
	}
	@Override
	public RevenueVO selectOne(String revenueCode) throws Exception {
		// TODO Auto-generated method stub
		return adao.selectOne(revenueCode);
	}

	@Override
	public List<RevenueVO> selectAll() throws Exception {
		ModelAndView mv = new ModelAndView("account");
		return adao.selectAll();
	}


}
