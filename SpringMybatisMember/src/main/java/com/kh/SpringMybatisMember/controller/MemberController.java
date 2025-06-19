package com.kh.SpringMybatisMember.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.SpringMybatisMember.domain.MybatisMember;
import com.kh.SpringMybatisMember.service.MemberDAOService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan(basePackages = "com.kh.SpringMybatisMember.mapper")
@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberDAOService memberService;

    // 게시판 입력 화면 요청
    @GetMapping("/insertForm")
    public String insertForm(MybatisMember member, Model model) throws Exception {
        log.info("insertForm");
        model.addAttribute("member", member);
        return "member/insert";
    }

    // 게시판 입력
    @PostMapping("/insert")
    public String insert(MybatisMember member, Model model) throws Exception {
        log.info("insert");
        memberService.insert(member);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "member/success";
    }

    // 게시판 전체 출력
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        log.info("list");
        model.addAttribute("list", memberService.selectAll());
        return "member/list";
    }

    // 게시판 출력(No)
    @GetMapping("/read")
    public String read(MybatisMember member, Model model) throws Exception {
        log.info("read");
        model.addAttribute("member", memberService.select(member));
        return "member/read";
    }

    // 게시판 삭제
    @PostMapping("/delete")
    public String delete(MybatisMember member, Model model) throws Exception {
        log.info("delete");
        memberService.delete(member);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "member/success";
    }

    // 게시판 수정 화면 요청
    @GetMapping("/modify")
    public String modifyForm(MybatisMember member, Model model) throws Exception {
        log.info("modifyForm");
        model.addAttribute("member", memberService.select(member));
        return "member/modify";
    }

    // 게시판 수정
    @PostMapping("/modify")
    public String modify(MybatisMember member, Model model) throws Exception {
        log.info("modify");
        memberService.update(member);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "member/success";
    }
}
