package com.example.practice.vo;

import lombok.Data;


@Data
public class MemberVO {
	// html의 name이름과 vo의 변수명과 데이터베이스 컬럼은
	// 일치해야 자동으로 매핑 해 준다.
	private String id;
	private String pass;
	private String name;
	private String tel;
	private String email;
	private String address;
	private String company_code;
	private String department_code;

	public MemberVO() {

	}

}
