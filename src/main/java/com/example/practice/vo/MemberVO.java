package com.example.practice.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	// html의 name이름과 vo의 변수명과 데이터베이스 컬럼은
	// 일치해야 자동으로 매핑 해 준다.
	String id;
	String pass;
	String name;
	String tel;
	String email;
	String address;
	String company_code;
	String department_code;

}
