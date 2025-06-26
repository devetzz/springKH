package com.kh.SpringBootSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {
    @RequestMapping("/list")
    public String list() {
        log.info("list : 모두가 접근 가능");
        return "board/list";
    }

    @RequestMapping("/register")
    public String registerForm() {
        log.info("registerForm : 로그인한 회원만 접근 가능");
        return "board/register";
    }
}
