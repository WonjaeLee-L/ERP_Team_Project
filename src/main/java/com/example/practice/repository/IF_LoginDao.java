package com.example.practice.repository;

import com.example.practice.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IF_LoginDao {
    public void insertOne(MemberVO membervo) throws Exception;
    public MemberVO selectOne(String id, String pass) throws Exception;
}
