package com.kh.SpringBootInterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.SpringBootInterceptor.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    // 1. 사용자 요청 정보
    public String loginForm() {
        log.info("2번 LoginController loginForm start");
        // 2. 디비연동 (mapper 인터페이스 사용, 다형성 구현)
        // 3. 디비연동 리턴값을 화면전달(view resolver, redirect, forward, responseBody:json)
        return "login/loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(Member member, Model model) {
        log.info("2번 LoginController loginForm start");
        log.info("login userId = " + member.getUserId());
        log.info("login userPw = " + member.getUserPw());

        member.setUserName("제우스");
        member.setEmail("zeus@zeus.com");
        model.addAttribute("user", member);
    }

}
