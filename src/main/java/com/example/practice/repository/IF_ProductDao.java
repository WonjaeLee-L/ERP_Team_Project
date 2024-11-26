package com.example.practice.repository;

import com.example.practice.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IF_ProductDao {
    public List<ProductVO> selectAll(ProductVO productvo) throws Exception;
    public void insertProduct(ProductVO productVO) throws Exception;
    public List<ProductVO> selectProduct(String search) throws Exception;
    public ProductVO selectOneProduct(String oneSearch) throws Exception;
    public void deleteProduct(String delcode) throws Exception;
    public void updateProduct(ProductVO productVO) throws Exception;
}
