package com.zeus.DevProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.CheckBoxLabelValue;
import com.zeus.domain.CodeLabelValue;
import com.zeus.domain.User;

import lombok.extern.slf4j.Slf4j;

// 사용자 요청을 받고 정보(http://127.0.0.1:8080/home)를 받는다. 해당되는 DB를 연동한다. 결과값을 해당되는 view로 넘겨준다.
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping(value = "/registerForm")
    public String registerForm(Model model) {
        log.info("registerForm");
        User user = new User();
        user.setUserId("kimid");
        user.setUserName("홍길동");
        user.setUserPassword("123456");
        user.setUserIntroduction("유저입니다.");

        ArrayList<CheckBoxLabelValue> cbList = new ArrayList<CheckBoxLabelValue>();
        cbList.add(new CheckBoxLabelValue("스포츠", "sports"));
        cbList.add(new CheckBoxLabelValue("영화", "movie"));
        cbList.add(new CheckBoxLabelValue("음악", "music"));

        model.addAttribute("hobbyBoxList", cbList);
        model.addAttribute("user", user);
        return "user/registerForm";
    }

    // @PostMapping(value = "/register")
    // public String register(User user) {
    //     log.info("register");
    //     // log.info("userId = " + user.getUserId());
    //     // log.info("userName = " + user.getUserName());
    //     // log.info("userPassword = " + user.getUserPassword());
    //     // log.info("userIntroduction = " + user.getUserIntroduction());
    //     log.info("gender = " + user.getGender());
        
    //     // List<String> cbList = user.getCbList();
    //     // if (cbList != null) {
    //     //     log.info("hobbyList != null = " + cbList.size());

    //     //     for (int i = 0; i < cbList.size(); i++) {
    //     //         log.info("checkBoxList(" + i + ") = " + cbList.get(i));
    //     //     }
    //     // } else {
    //     //     log.info("checkBoxList == null");
    //     // }

    //     return "user/resultForm";
    // }

    @GetMapping("/radiobuttons01")
    public String registerSpringFormRadiobuttons01(Model model) { 
        log.info("radiobuttons01");

        Map<String, String> nationalityCodeMap = new HashMap<String, String>(); 
        nationalityCodeMap.put("01", "Korea");
        nationalityCodeMap.put("02", "Germany"); 
        nationalityCodeMap.put("03", "Australia");
        model.addAttribute("nationalityCodeMap", nationalityCodeMap);
        model.addAttribute("user", new User());

        return "user/radiobuttons01";      // 뷰 파일명
    }

    @GetMapping("/registerSpringFormErrors")
    public String registerSpringFormErrors(Model model) {
        log.info("registerSpringFormErrors");
        User user = new User();
        user.setEmail("aaa@ccc.com"); 
        user.setUserName("홍길동");
        model.addAttribute("user", user);
        return "user/registerSpringFormErrors"; // 뷰 파일명
    }

    // 입력 처리
    @PostMapping("/register")
    public String register(@Validated User user, BindingResult result) {
        log.info("register");
        // 에러 처리
        if(result.hasErrors()) {
            return "user/registerSpringFormErrors";
        }
        
        return "user/resultForm";
    }
    
}
