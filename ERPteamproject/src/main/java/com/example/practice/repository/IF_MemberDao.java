package com.example.practice.repository;


import com.example.practice.vo.MemberVO;
import com.example.practice.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IF_MemberDao {

	public void insertOne(MemberVO membervo)throws Exception;
	public MemberVO selectOne(String id) throws Exception;

}
