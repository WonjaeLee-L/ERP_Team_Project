package com.example.practice.controller;

import com.example.practice.service.IF_MemberService;
import com.example.practice.service.IF_ProductService;
import com.example.practice.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IF_ProductService productservice;


    // 물품 등록 화면 이동
    @RequestMapping("/storage")
    public String storage() throws Exception {
        return "storage";
    }

    // 물품 등록
    @PostMapping("/product")
    public String product(@ModelAttribute ProductVO productVO) throws Exception {
        productservice.insertProduct(productVO);
        return "redirect:storage";
    }

    // 물품 확인
    @GetMapping("/productlistview")
    public String product(Model model, @ModelAttribute ProductVO productVO) throws Exception {
        List<ProductVO> productlist = productservice.selectAll(productVO);
        model.addAttribute("productlist", productlist);
        return "list";
    }

}
