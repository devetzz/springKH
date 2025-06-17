package com.zeus.DevProject.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.domain.Member;

import lombok.extern.slf4j.Slf4j;

// 사용자 요청을 받고 정보(http://127.0.0.1:8080/home)를 받는다. 해당되는 DB를 연동한다. 결과값을 해당되는 view로 넘겨준다.
@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String registerForm() {
        log.info("registerForm");
        return "member/registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Member member, int userId) {
        log.info("registerForm");
        log.info("userId = " + userId);
        log.info("member = " + member);
        log.info("member = " + member.getDateOfBirth());
        return "member/success";
    }

    @RequestMapping(value = "/registerSelect", method = RequestMethod.POST)
    public String registerSelect(Member member) {
        log.info("registerSelect");
        for(int i = 0; i < member.getNationality().size(); i++){
            log.info("nationality member = " + member.getNationality().get(i));
        }
        return "member/success";
    }

    @RequestMapping(value = "/registerBoard", method = RequestMethod.POST)
    public String registerBoard(Member member) {
        log.info("registerForm");
        log.info("member.getUserId() = " + member.getUserId());
        log.info("member.getPassword() = " + member.getPassword());
        log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
        log.info("member.getBoard().getBoardNo() = " + member.getBoard().getBoardNo());
        return "member/success";
    }

    // @RequestMapping(value = "/registerFileupload", method = RequestMethod.POST)
    // public String registerFileupload(MultipartFile[] picture) {
    //     log.info("registerFileupload");
    //     for(MultipartFile data : picture){
    //         log.info("serverUseName: " + data.getName());
    //         log.info("originalName: " + data.getOriginalFilename());
    //         log.info("size: " + data.getSize());
    //         log.info("contentType: " + data.getContentType());
    //     }

    //     return "member/success";
    // }
    @RequestMapping(value = "/registerFileupload", method = RequestMethod.POST)
    public String registerFileupload(Member member) throws IllegalStateException, IOException {
        log.info("registerFileupload");
        for(MultipartFile data : member.getPicture()){
            log.info("serverUseName: " + data.getName());
            log.info("originalName: " + data.getOriginalFilename());
            log.info("size: " + data.getSize());
            log.info("contentType: " + data.getContentType());
            data.transferTo(new File("\\\\192.168.30.15\\move\\springBootUploadFile/" + data.getOriginalFilename()));;
        }

        return "member/success";
    }

    @GetMapping("/registerAjaxFileUpForm") 
        public String registerAjaxFileUpForm() { 
        log.info("registerAjaxFileUpForm"); 
        return "member/registerAjaxFileUpForm"; // 뷰 파일명 
    }

    @PostMapping(value = "/uploadAjax", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> uploadAjax(@RequestBody MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        log.info("originalName: " + originalFilename);
        ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD SUCCESS" + originalFilename, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/form")
    public String form() {
        log.info("form");
        return "member/form";
    }

    // RedirectAttributes rttr : 임시로 데이터를 세션에 저장하고, 다시 페이지 요청 세션 -> Request
    // @PostMapping(value = "/submit")
    // public String submit(@RequestParam String name, RedirectAttributes rttr, Model model) throws IllegalStateException, IOException {
    //     log.info("submit name" + name);

    //     rttr.addFlashAttribute("message", name + "님이 등록되었습니다.");
    //     model.addAttribute("name", name);
    //     return "member/result"; // 새로고침했을때 결과를 또 전송 하는 문제 발생
    // }
    @PostMapping(value = "/submit")
    public String submit(@RequestParam String name, RedirectAttributes rttr, Model model) throws IllegalStateException, IOException {
        log.info("submit name" + name);

        rttr.addFlashAttribute("message", name + "님이 등록되었습니다.");
        model.addAttribute("name", name);
        return "redirect:/member/result";   // 새로고침해도 데이터는 재전송 하지 않음
    }


    @GetMapping("/result")
    public String result() {
        log.info("result");
        return "member/result";
    }


}
