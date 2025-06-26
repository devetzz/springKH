package com.kh.SpringBootSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/notice")
@Controller
public class NoticeController {
    @RequestMapping("/list")
    public String list() {
        log.info("list : 모두가 접근 가능");
        return "notice/list";
    }

    @RequestMapping("/register")
    public String registerForm() {
        log.info("registerForm : 로그인한 관리자만 접근 가능");
        return "notice/register";
    }
}
