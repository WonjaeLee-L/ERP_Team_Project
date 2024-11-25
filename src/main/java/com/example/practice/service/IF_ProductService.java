package com.example.practice.service;

import com.example.practice.vo.ProductVO;

import java.util.List;

public interface IF_ProductService {
    public List<ProductVO> selectAll(ProductVO productvo) throws Exception;
    public void insertProduct(ProductVO productVO) throws Exception;
    public List<ProductVO> selectProduct(String product_name) throws Exception;
    public void deleteProduct(String delcode) throws Exception;
//    public void updateProduct(ProductVO productVO) throws Exception;
}
