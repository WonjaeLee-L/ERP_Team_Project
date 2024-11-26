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
    public List<ProductVO> selectProduct(String search) throws Exception {
        System.out.println("selectProduct product_name: " + search);  // Add debug
        if (search == null || search.isEmpty()) {
            System.out.println("product_name이 null이거나 비어 있습니다.");

            return Collections.emptyList();
        }
        System.out.println("selectProduct 결과: ");  // 결과 디버그
        List<ProductVO> productVOList = productDao.selectProduct(search);
        System.out.println(productVOList);
        return productDao.selectProduct(search);
//        return productDao.selectProduct(product_name);
    }

    @Override
    public ProductVO selectOneProduct(String oneSearch) throws Exception {

        return productDao.selectOneProduct(oneSearch);
    }

    @Override
    public void deleteProduct(String delcode) throws Exception {
        productDao.deleteProduct(delcode);
    }

    @Override
    public void updateProduct(ProductVO productVO) throws Exception {
        productDao.updateProduct(productVO);
    }


}
