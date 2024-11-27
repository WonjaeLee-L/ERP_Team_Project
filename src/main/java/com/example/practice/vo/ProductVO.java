package com.example.practice.vo;

import lombok.Data;
import lombok.Getter;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Data
public class ProductVO {

    String product_code;
    String product_name;
    int sale_price;
    int price;
    String category_code;
    String product_img;
    String product_explain;
    String company_code;

//    public String getThumbnail() {
//        return URLEncoder.encode(product_img, StandardCharsets.UTF_8);
//    }

}
