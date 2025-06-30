package com.kh.ImageShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.ImageShop.domain.CodeLabelValue;
import com.kh.ImageShop.domain.Member;
import com.kh.ImageShop.service.CodeService;
import com.kh.ImageShop.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
    @Autowired
    private MemberService service;

    @Autowired
    private CodeService codeService;

    // 스프링 시큐리티의 비밀번호 암호처리기
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 등록 페이지
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void registerForm(Member member, Model model) throws Exception {
        // 직업코드 목록을 조회하여 뷰에 전달
        String groupCode = "A00";
        List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
        model.addAttribute("jobList", jobList);
    }

    // 등록 처리
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated Member member, BindingResult result,
            Model model, RedirectAttributes rttr) throws Exception {
        if (result.hasErrors()) {
            // 직업코드 목록을 조회하여 뷰에 전달
            String groupCode = "A00";
            List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
            model.addAttribute("jobList", jobList);
            return "user/register";
        }
        // 비밀번호 암호화
        String inputPassword = member.getUserPw();
        member.setUserPw(passwordEncoder.encode(inputPassword));
        service.register(member);
        rttr.addFlashAttribute("userName", member.getUserName());
        return "redirect:/user/registerSuccess";
    }

    // 등록 성공 페이지
    @RequestMapping(value = "/registerSuccess", method = RequestMethod.GET)
    public void registerSuccess(Model model) throws Exception {
    }

    // 목록 페이지
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(Model model) throws Exception {
        model.addAttribute("list", service.list());
    }

    // 상세 페이지
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public void read(int userNo, Model model) throws Exception {
        // 직업코드 목록을 조회하여 뷰에 전달
        String groupCode = "A00";
        List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
        model.addAttribute("jobList", jobList);
        model.addAttribute(service.read(userNo));
    }

    // 수정 페이지
    @RequestMapping(value = "/modify", method = RequestMethod.GET) 
    public void modifyForm(int userNo, Model model) throws Exception {
        // 직업코드 목록을 조회하여 뷰에 전달
        String groupCode = "A00";
        List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
        model.addAttribute("jobList", jobList);
        model.addAttribute(service.read(userNo));
    }
    // 수정 처리
    @RequestMapping(value = "/modify", method = RequestMethod.POST) 
    public String modify(Member member, RedirectAttributes rttr) throws Exception {
        service.modify(member);
        rttr.addFlashAttribute("msg", "SUCCESS"); return "redirect:/user/list";
    }

    // 삭제 처리
    @RequestMapping(value = "/remove", method = RequestMethod.POST) 
    public String remove(int userNo, RedirectAttributes rttr) throws Exception {
        service.remove(userNo);
        rttr.addFlashAttribute("msg", "SUCCESS"); return "redirect:/user/list";
    }
}
