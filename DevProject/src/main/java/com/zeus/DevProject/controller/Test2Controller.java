package com.zeus.DevProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeus.domain.Board;

import lombok.extern.slf4j.Slf4j;


// 사용자 요청을 받고 정보(http://127.0.0.1:8080/home)를 받는다. 해당되는 DB를 연동한다. 결과값을 해당되는 view로 넘겨준다.
@Slf4j
@Controller
public class Test2Controller {
    
    // gohome06 get 요청 => (DB연동 처리) => /gohome05 redirect =>
    // gohome05 요청 => gohome07 view Resolver 통해서 보여준다.
    @GetMapping("/sub/gohome06")
    public String gohome06() {
        log.info("/sub/gohome06");

        return "redirect:/sub/gohome05";
    }

    @GetMapping("/sub/gohome05")
    public String gohome05() {
        log.info("/sub/gohome05");

        return "sub/gohome07";
    }
    @GetMapping("/gohome08")
    public @ResponseBody Map<String,Board> home08(Model model) {
        log.info("자바빈즈 클래스 타입 home08");
        Map<String,Board> map = new HashMap<>();
        Board board = new Board();
        board.setBoardNo(20);
        map.put("key1", board);

        Board board2 = new Board();
        board2.setBoardNo(30);
        map.put("key2", board2);

        return map;
    }


    
    


}
