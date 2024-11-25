package com.example.practice.controller;

import com.example.practice.service.IF_MemberService;
import com.example.practice.service.IF_ProductService;
import com.example.practice.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {


    private final IF_ProductService productservice;


    // 물품 등록 화면 이동
    @RequestMapping("/storage")
    public String storage() throws Exception {
        return "storage";
    }

    // 물품 등록
    @PostMapping("/product")
    public String product(@ModelAttribute ProductVO productVO) throws Exception {
        productservice.insertProduct(productVO);
        return "redirect:productlistview";
    }

    // 물품 전체 리스트
    @GetMapping("/productlistview")
    public String product(Model model, @ModelAttribute ProductVO productVO) throws Exception {
        List<ProductVO> productlist = productservice.selectAll(productVO);
        model.addAttribute("productlist", productlist);
        return "MainProduct";
    }

    // 물품 검색, 이름 다중 검색
    @GetMapping("/productoneview")
    public String productOneView(@RequestParam("search1") String product_name, Model model, @ModelAttribute ProductVO productVO) throws Exception {
        System.out.println("Method productOneView is called");
        List<ProductVO> productVOS = productservice.selectProduct(product_name);
        System.out.println("확인: " + product_name);  // 값 디버그
        model.addAttribute("productVOS", productVOS);
        // 입력 안하고 검색하면, 전체 리스트 호출
        if (productVOS.isEmpty()) {
            return "redirect:productlistview";
        }
        return "MainProduct";
    }

    // 리스트에서 물품 삭제
    @GetMapping("del")
    public String del(@RequestParam("delcode") String delcode) throws Exception {
        productservice.deleteProduct(delcode);
        return "redirect:productlistview";
    }

    @PostMapping("/productmod")
    public String productmod(@RequestBody ProductVO productVO) throws Exception {
        productservice.selectProduct(productVO.getProduct_name());
        return "redirect:productlistview";
    }


}