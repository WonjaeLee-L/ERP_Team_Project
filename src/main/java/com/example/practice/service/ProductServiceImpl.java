package com.example.practice.service;

import com.example.practice.repository.IF_MemberDao;
import com.example.practice.repository.IF_ProductDao;
import com.example.practice.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IF_ProductService{


    private final IF_ProductDao productDao;

    @Override
    public List<ProductVO> selectAll(ProductVO productvo) throws Exception {
        return productDao.selectAll(productvo);
    }

    @Override
    public void insertProduct(ProductVO productVO) throws Exception {
        productDao.insertProduct(productVO);
    }

    @Override
    public List<ProductVO> selectProduct(String product_name) throws Exception {
        System.out.println("selectProduct product_name: " + product_name);  // Add debug
        if (product_name == null || product_name.isEmpty()) {
            System.out.println("product_name이 null이거나 비어 있습니다.");

            return Collections.emptyList();
        }
        System.out.println("selectProduct 결과: ");  // 결과 디버그
        List<ProductVO> productVOList = productDao.selectProduct(product_name);
        System.out.println(productVOList);
        return productDao.selectProduct(product_name);
//        return productDao.selectProduct(product_name);
    }

    @Override
    public void deleteProduct(String delcode) throws Exception {
        productDao.deleteProduct(delcode);
    }
}
