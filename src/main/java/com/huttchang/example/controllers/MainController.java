package com.huttchang.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.controllers
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 6. 4.
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String welcome() throws Exception {
        System.out.println("welcome");
        return "index";
    }
}
