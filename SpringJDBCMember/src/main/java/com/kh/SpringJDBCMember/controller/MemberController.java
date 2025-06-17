package com.kh.SpringJDBCMember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.SpringJDBCMember.domain.Member;
import com.kh.SpringJDBCMember.service.MemberService;

import lombok.extern.java.Log;


@Log
@Controller
@RequestMapping("/member")
public class MemberController {
    // 의존성 주입(생성자, 필드주입, 셋터주입)
    @Autowired
    private MemberService memberService;
    
    // 게시판 입력 화면 요청
    @GetMapping("/insertForm")
    public String insertForm(Member member, Model model) throws Exception {
        log.info("insertForm");
        return "member/insert";
    }

    // 게시판 입력
    @PostMapping("/insert")
    public String insert(Member member, Model model) throws Exception {
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
    public String read(Member member, Model model) throws Exception {
        log.info("read");
        model.addAttribute(memberService.select(member));
        return "member/read";
    }

    // 게시판 삭제
    @PostMapping("/delete")
    public String delete(Member member, Model model) throws Exception {
        log.info("delete");
        memberService.delete(member);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "member/success";
    }

    // 게시판 수정 화면 요청
    @GetMapping("/modify")
    public String modifyForm(Member member, Model model) throws Exception {
        log.info("modifyForm");
        model.addAttribute(memberService.select(member));
        return "member/modify";
    }

    // 게시판 수정
    @PostMapping("/modify")
    public String modify(Member member, Model model) throws Exception {
        log.info("modify");
        memberService.update(member);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "member/success";
    }

}
