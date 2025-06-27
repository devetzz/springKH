package com.kh.ImageShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.ImageShop.domain.CodeGroup;
import com.kh.ImageShop.service.CodeGroupService;

@Controller
@RequestMapping("/codegroup")
public class CodeGroupController {

    @Autowired
    private CodeGroupService service;

    // 등록 페이지
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void registerForm(Model model) throws Exception {
        CodeGroup codeGroup = new CodeGroup();
        model.addAttribute(codeGroup);
    }

    // 등록처리
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(CodeGroup codeGroup, RedirectAttributes rttr)
            throws Exception {
        service.register(codeGroup);
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codegroup/list";
    }

    // 목록 페이지
    @RequestMapping(value = "/list", method = RequestMethod.GET) public void list(Model model) throws Exception {
        model.addAttribute("list", service.list());
    }
}
