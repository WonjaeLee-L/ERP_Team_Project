package com.example.practice.service;

import com.example.practice.repository.IF_MemberDao;
import com.example.practice.repository.IF_ProductDao;
import com.example.practice.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IF_ProductService{

    @Autowired
    IF_ProductDao productDao;

    @Override
    public List<ProductVO> selectAll(ProductVO productvo) throws Exception {

        return productDao.selectAll(productvo);
    }

    @Override
    public void insertProduct(ProductVO productVO) throws Exception {
        productDao.insertProduct(productVO);
    }
}
