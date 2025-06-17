package com.zeus;

import org.junit.jupiter.api.Test;

import com.zeus.domain.Board;

public class LombokTest {
    @Test
    public void testNoArgsConstructor(){
        Board board = new Board();
        System.out.println(board);
    }

//    @Test
//    public void testSetter(){
//        Board board = new Board("테스트제목");
//        System.out.println(board);
//        System.out.println(board.getTitle());
//    }
}
