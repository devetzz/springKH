package com.kh.SpringBootAOP.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.SpringBootAOP.domain.AopBoard;
import com.kh.SpringBootAOP.service.BoardDAOService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.kh.SpringBootAOP.mapper")
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardDAOService bds;

    // 게시판 입력 화면 요청
    @RequestMapping(value = "/registerForm", method = RequestMethod.GET) 
    public String registerForm(AopBoard board, Model model) throws Exception {
        model.addAttribute("board", board);
        log.info("registerForm");
        return "board/register";
    }
    // 게시판 디비 입력 요청
    @RequestMapping(value = "/register", method = RequestMethod.POST) 
    public String register(AopBoard board, Model model) throws Exception {
        bds.insert(board);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "board/success";
    }
    // 게시판 리스트 화면 요청
    @RequestMapping(value = "/list", method = RequestMethod.GET) 
    public String list(Model model) throws Exception {
        log.info("list");
        model.addAttribute("list", bds.selectAll());
        return "board/list";
    }
    // 게시판 상세 화면 요청
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(AopBoard board, Model model) throws Exception {
        model.addAttribute("board",bds.select(board));
        return "board/read";
    }
    // 게시판 삭제 요청
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(AopBoard board, Model model) throws Exception {
        bds.delete(board);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "board/success";
    }
    // 게시판 수정 화면 요청
    @RequestMapping(value = "/modify", method = RequestMethod.GET) 
    public String modifyForm(AopBoard board, Model model) throws Exception {
        model.addAttribute("board",bds.select(board));
        return "board/modify";
    }
    // 게시판 수정 요청
    @RequestMapping(value = "/modify", method = RequestMethod.POST) 
    public String modify(AopBoard board, Model model) throws Exception {
        bds.update(board);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "board/success";
    }

}
