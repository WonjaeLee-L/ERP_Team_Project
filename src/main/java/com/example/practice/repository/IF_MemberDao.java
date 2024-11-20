package com.example.practice.repository;


import com.example.practice.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IF_MemberDao {

	public void insertOne(MemberVO membervo)throws Exception;
	public MemberVO selectOne(String id) throws Exception;

}
