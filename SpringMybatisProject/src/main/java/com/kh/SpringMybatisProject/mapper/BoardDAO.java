package com.kh.SpringMybatisProject.mapper;

import java.util.List;

import com.kh.SpringMybatisProject.domain.MybatisBoard;

public interface BoardDAO {

    // 게시판 삽입
    public void insert(MybatisBoard board) throws Exception;

    // 게시판 출력(one)
    public MybatisBoard select(MybatisBoard board) throws Exception;

    // 게시판 수정
    public void update(MybatisBoard board) throws Exception;

    // 게시판 삭제
    public void delete(MybatisBoard board) throws Exception;

    // 게시판 전체 출력
    public List<MybatisBoard> selectAll() throws Exception;
}
