package com.kh.SpringMybatisProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.SpringMybatisProject.domain.MybatisBoard;
import com.kh.SpringMybatisProject.exception.BoardRecordNotFoundException;
import com.kh.SpringMybatisProject.mapper.BoardDAO;

@Service
public class BoardDAOServiceImpl implements BoardDAOService{

    @Autowired
    private BoardDAO bd;

    @Override
    public void insert(MybatisBoard board) throws Exception {
        bd.insert(board);
    }

    @Override
    public MybatisBoard select(MybatisBoard board) throws Exception {
        // 게시글이 존재하지 않으면 정의한 예외를 발생시킨다. if(board == null) {
        //사용자가 정의한 예외처리함수(BoardRecordNotFoundException)
        MybatisBoard _board = bd.select(board);
        if(_board == null){
            throw new BoardRecordNotFoundException(board.getNo() + " 번 게시글은 없는 게시글입니다.");
        }
        return _board;
    }

    @Override
    public void update(MybatisBoard board) throws Exception {
        bd.update(board);
    }

    @Override
    public void delete(MybatisBoard board) throws Exception {
        bd.delete(board);
    }

    @Override
    public List<MybatisBoard> selectAll() throws Exception {
        return bd.selectAll();
    }

}
