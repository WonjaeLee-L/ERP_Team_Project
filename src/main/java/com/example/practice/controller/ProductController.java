package com.example.practice.controller;

import com.example.practice.FileHandler.ProductFile;
import com.example.practice.service.IF_ProductService;
import com.example.practice.vo.ProductVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.Banner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequiredArgsConstructor
public class ProductController {


    private final ProductFile productFile;
    private final IF_ProductService productservice;

    @RequestMapping("/aa")
    public String dd() throws Exception {
        return "list";
    }
    // 물품 등록 화면 이동
    @RequestMapping("/storage")
    public String storage() throws Exception {
        return "storage";
    }

    // 물품 등록 ok
    @PostMapping("/product")
    public String product(@ModelAttribute ProductVO productVO,@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
//        if (file.isEmpty()) {
//            System.out.println("null");
//        }else {
//            System.out.println("체크");
//        }
        String saveFileName = productFile.saveFile(file);
        productVO.setProduct_img(saveFileName);
        System.out.println(saveFileName);
        productservice.insertProduct(productVO);
        return "redirect:productlistview";
    }

    @ResponseBody
    @GetMapping("/{product_img}")
    public UrlResource showImage(@PathVariable("product_img") Long img, HttpServletResponse response, InputStream inputStream) throws IOException {

//        img = URLDecoder.decode(img, "UTF-8");
        response.setContentType("image/jpeg");
        InputStream i = new ByteArrayInputStream("product_img".getBytes());
        IOUtils.copy(i, response.getOutputStream());

        return new UrlResource("file:" + "product_img");
//        return new UrlResource("file:"+ img);
    }

//    @GetMapping("/{product_img}")
//    public ResponseEntity<byte[]> imgview(@PathVariable("product_img") Long img) throws Exception {
//        InputStream ii = new FileInputStream(""+img);
//        byte[] imageByteArray = IOUtils.copy(i)
//        ii.close();
//        return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
//    }
//@GetMapping("/{product_img}")
//public void renderImageFromDB(@PathVariable("product_img") Long im, HttpServletResponse response)
//        throws IOException {
//
//    log.debug("renderImageFromDB in IamgeController");
//
//
//
//        byte[] byteArray = new byte[recipeCommand.getImage().length];
//
//        int index = 0;
//        for (byte b : recipeCommand.getImage()) {
//            byteArray[index++] = b;
//
//
//        response.setContentType("image/jpeg");
//        InputStream is = new ByteArrayInputStream(byteArray);
//        IOUtils.copy(is, response.getOutputStream());
//    }
//}
//    @GetMapping("/{product_img}")
//    public void imgview(@PathVariable("product_img") Long img, HttpServletResponse response) throws IOException {
//
//    }

    //    @GetMapping("'/display?filename='+${data_product.product_img}")
//    @ResponseBody
//    public Resource viewimg(@PathVariable("data_product.product_img") long product_img, Model model) throws Exception {
//        FileEntity file = productFile.
//    }
//    @GetMapping("/display")
//    public ResponseEntity<Resource> viewimage(@RequestParam("filename") String filename) throws Exception {
//        String uploadDir = "C:/Data/aa/projectSample-master/src/main/resources/static/productImg/";
//        uploadDir = URLEncoder.encode(uploadDir, "UTF-8");
//        FileSystemResource resource = new FileSystemResource(uploadDir + filename);
//        if(!resource.exists())
//            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
//        HttpHeaders header = new HttpHeaders();
//        Path filePath = null;
//        try{
//            filePath = Paths.get(uploadDir + filename);
//            header.add("Content-type", Files.probeContentType(filePath));
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<Resource>((Resource) resource, header, HttpStatus.OK);
//    }

    // 물품 전체 리스트
    @GetMapping("/productlistview")
    public String product(Model model, @ModelAttribute ProductVO productVO) throws Exception {
        List<ProductVO> productlist = productservice.selectAll(productVO);
        System.out.println(productVO.getProduct_img());
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

    // 단일 검색
//    @PostMapping("/productmod")
//    public String productmod(@RequestBody ProductVO productVO) throws Exception {
//        productservice.selectOneProduct(productVO.getProduct_name());
//
//        return null;// 여기서, 입력 창 열고,
//    }

    // 새로 입력 받은 내용 수정
//    @PostMapping("임시값")
//    public void productMod(@ModelAttribute ProductVO productVO) throws Exception {
//        productservice.updateProduct(productVO);
//    }
// 최신 본
}