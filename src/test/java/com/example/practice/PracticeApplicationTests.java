package com.example.practice;

import com.example.practice.repository.IF_AccountDao;
import com.example.practice.vo.RevenueVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

@SpringBootTest
class PracticeApplicationTests {

    @Autowired
    ModelAndView modelAndView;

    @Autowired
    IF_AccountDao adao;

    @Test
    void contextLoads() {
        System.out.println(modelAndView);
    }

    @Test
    void selOne() throws Exception {
        RevenueVO rvo = adao.selectOne("1100");
        System.out.println(rvo);
    }

}
