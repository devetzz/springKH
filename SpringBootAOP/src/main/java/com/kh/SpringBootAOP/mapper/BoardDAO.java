package com.kh.SpringBootAOP.mapper;

import java.util.List;

import com.kh.SpringBootAOP.domain.AopBoard;

public interface BoardDAO {

    // 게시판 삽입
    public void insert(AopBoard board) throws Exception;

    // 게시판 출력(one)
    public AopBoard select(AopBoard board) throws Exception;

    // 게시판 수정
    public void update(AopBoard board) throws Exception;

    // 게시판 삭제
    public void delete(AopBoard board) throws Exception;

    // 게시판 전체 출력
    public List<AopBoard> selectAll() throws Exception;
}
