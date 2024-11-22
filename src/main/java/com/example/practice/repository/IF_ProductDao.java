package com.example.practice.repository;

import com.example.practice.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IF_ProductDao {
    public List<ProductVO> selectAll(ProductVO productvo) throws Exception;
    public void insertProduct(ProductVO productVO) throws Exception;
    public ProductVO selectProduct(String name) throws Exception;
}
