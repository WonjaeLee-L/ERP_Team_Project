package com.example.practice.vo;

public class MemberVO {
	// html의 name이름과 vo의 변수명과 데이터베이스 컬럼은
	// 일치해야 자동으로 매핑 해 준다. 
	String id = null;
	String pass =null;
	String name = null;
	String tel = null;
	String email = null;
	String address = null;
	String company_code = null;
	String department_code = null;

	@Override
	public String toString() {
		return "MemberVO{" +
				"id='" + id + '\'' +
				", pass='" + pass + '\'' +
				", name='" + name + '\'' +
				", tel='" + tel + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", company_code='" + company_code + '\'' +
				", department_code='" + department_code + '\'' +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany_code() {
		return company_code;
	}

	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	public String getDepartment_code() {
		return department_code;
	}

	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}
}
