package com.zeus.DevProject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeus.domain.Board;

import lombok.extern.slf4j.Slf4j;

// 사용자 요청을 받고 정보(http://127.0.0.1:8080/home)를 받는다. 해당되는 DB를 연동한다. 결과값을 해당되는 view로 넘겨준다.
@Slf4j
@Controller
     // @Controller + @ResponceBody
public class TestController {
    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    // 클래스 선언할 때 @RestController 선언할경우 여기서 @ResponseBody 생략해도 된다.
    public String hello(@RequestParam("name") String rename) {
        return "hello " + rename;
    }

    @RequestMapping(value = "/getBoard", method = RequestMethod.GET)
    public @ResponseBody Board getBoard() {
        Board board = new Board();
        board.setBoardNo(0);
        board.setTitle("Hello");
        board.setContent("zeus");
        board.setWriter("kdj");
        board.setRegDate(new Date());
        return board;
    }

    @RequestMapping(value = "/board/getBoard", method = RequestMethod.GET)
    public @ResponseBody List<Board> getBoardList() {
        List<Board> boardList = new ArrayList<Board>();
        for(int i=1; i<= 10; i++) {
            Board board = new Board();
            board.setBoardNo(i);;
            board.setTitle("Hello");
            board.setContent("zeus");;
            board.setWriter("kdj");;
            board.setRegDate(new Date());
            boardList.add(board);
        }
            return boardList;
    }

}
