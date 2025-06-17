package com.zeus.DevProject.controller;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeus.domain.Board;

import lombok.extern.java.Log;



// 사용자 요청을 받고 정보(http://127.0.0.1:8080/home)를 받는다. 해당되는 DB를 연동한다. 결과값을 해당되는 view로 넘겨준다.
@Log
@Controller
public class HomeController {

    // http://127.0.0.1:8080/home get방식
    // Model, (Request, Response, Section, Application : 생명주기)
    @GetMapping(value = "/home")
    public String home(Locale locale, Model model){
        log.info("여기는 Home Controller home() 입니다." + locale.toString());
        log.info("여기는 Home Controller home() 입니다." + model.toString());
        // DB 연동하지 않는다.
        // view를 불러준다. (~ : view Resolver)
        Date date = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formatDate = df.format(date);
        // 모델(Request)
        model.addAttribute("serverTime", formatDate);

        return "views/home01";
    }

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    public String sub(Model model){
        Board board = new Board(10, "kdj", "zeus1", "김동진", null);
        model.addAttribute("board", board);

        return "home02";
    }

    @GetMapping(value = "/home03")
    public String home03(){
        return "home03";
    }


    @GetMapping(value = "/home04")
    public String home04(Locale locale, Model model){
        // 문자열배열, ArrayList => VO, DB
        String[] name = {"홍길동","제우스","톰캣"};
        List<String> nameList = Arrays.asList("홍길동","제우스","톰캣");
        model.addAttribute("name", name);
        model.addAttribute("nameList", nameList);
        return "home04";
    }

    @GetMapping(value = "/home05")
    public String home05(Model model){
        // HashMap 만들어서 (DB, 사용자입력) 화면으로 보냄, id, pwd, email, name, date
        Map mMap = new HashMap<>();
        mMap.put("id", "rlaeogus");
        mMap.put("pwd", "123456");
        mMap.put("email", "rlaeogus@nate.com");
        mMap.put("name", "kdi");
        mMap.put("date", new Date());
        model.addAttribute("mMap", mMap);

        return "home05";
    }

    @GetMapping(value = "/home0303")
    public String home0303(Model model){
        Board board = new Board();
        board.setTitle(" ");
        model.addAttribute("board", board);
        return "home0303";
    }

     @GetMapping(value = "/home0202")
    public String home0202(Model model){
        Board board = new Board();
        board.setTitle("spring boot");
        model.addAttribute("board", board);
        return "home0202";
    }

    // WEB-INF/views/home0901.jsp, Get방식 (함수명 오버로딩 위배조건 안되면 됨)
    @GetMapping(value = "/home0901")
    public String getMethodName() {
        return "home0901";
    }
    
    // WEB-INF/views/home0901.jsp, Get방식 , parameter value, model 전달해서 화면에 출력해달라
    @RequestMapping("/boardjstl/search")
    public void search(Board board, String title, Model model) {
        log.info("search keyword = " + board);
        log.info("search keyword title = " + title);
        model.addAttribute("board", board);
    }
    // 위아래 같은 동작
    // @RequestMapping("/boardjstl/search")
    // public String search1(String keyword, Model model) {
    //     log.info("search keyword = " + keyword);
    //     model.addAttribute("keyword", keyword);
    //     return "/boardjstl/search";
    // }

    @RequestMapping("/boardjstl/list")
    public void list() {
        log.info("/boardjstl/list");
    }
    @RequestMapping("/home1101")
    public void home1101() {
        log.info("/home1101");
    }

}
