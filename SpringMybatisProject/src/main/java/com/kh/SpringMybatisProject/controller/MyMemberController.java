package com.kh.SpringMybatisProject.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.SpringMybatisProject.domain.MyMember;
import com.kh.SpringMybatisProject.service.MyMemberDAOService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan(basePackages = "com.kh.SpringMybatisProject.mapper")
@Controller
@RequestMapping("/mymember")
public class MyMemberController {
    @Autowired
    private MyMemberDAOService mmds;

    // 회원 가입화면 요청
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(MyMember member, Model model) throws Exception {
        log.info("UserRegisterForm");
        model.addAttribute("mymember", member);
        return "mymember/register";
    }

    // 회원가입 처리 요청
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(MyMember member, Model model) throws Exception {
        mmds.insert(member);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "mymember/success";
    }

    // 회원 정보 전체 출력
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        model.addAttribute("list", mmds.selectAll());
        return "mymember/list";
    }

    // 회원 정보, 권한 출력 (조인)
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(MyMember member, Model model) throws Exception {
        model.addAttribute("mymember", mmds.selectJoin(member));
        return "mymember/read";
    }

    // 회원 , 권한 삭제
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove (MyMember member, Model model) throws Exception {
        mmds.delete(member);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "mymember/success";
    }

    // 회원 수정 화면 요청
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyForm(MyMember member, Model model) throws Exception {
        model.addAttribute("mymember", mmds.selectJoin(member));
        return "mymember/modify";
    }

    // 회원 정보 수정
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(MyMember member, Model model) throws Exception {
        mmds.update(member);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "mymember/success";
    }

}
