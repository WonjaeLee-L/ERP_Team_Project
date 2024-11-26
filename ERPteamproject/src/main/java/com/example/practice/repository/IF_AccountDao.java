package com.example.practice.repository;


import com.example.practice.vo.RevenueVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IF_AccountDao {

	public void insertOne(RevenueVO rvo)throws Exception;
	public RevenueVO selectOne(String revenueCode) throws Exception;
	public List<RevenueVO> selectAll() throws Exception;

}
