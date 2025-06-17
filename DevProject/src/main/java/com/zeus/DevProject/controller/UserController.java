package com.zeus.DevProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.CheckBoxLabelValue;
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

    @PostMapping(value = "/register")
    public String register(User user) {
        log.info("register");
        log.info("userId = " + user.getUserId());
        log.info("userName = " + user.getUserName());
        log.info("userPassword = " + user.getUserPassword());
        log.info("userIntroduction = " + user.getUserIntroduction());
        
        List<String> cbList = user.getCbList();
        if (cbList != null) {
            log.info("hobbyList != null = " + cbList.size());

            for (int i = 0; i < cbList.size(); i++) {
                log.info("checkBoxList(" + i + ") = " + cbList.get(i));
            }
        } else {
            log.info("checkBoxList == null");
        }

        return "user/resultForm";
    }

    

}
