package com.board.SpringJDBCBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.SpringJDBCBoard.domain.Board;
import com.board.SpringJDBCBoard.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
    // 의존성 주입
    @Autowired
    private BoardDAO boardDAO;

    @Override
    @Transactional
    public void insert(Board board) throws Exception {
        boardDAO.insert(board);
    }

    @Override
    public Board select(Board board) throws Exception {
        return boardDAO.select(board);
    }

    @Override
    public void update(Board board) throws Exception {
        boardDAO.update(board);
    }

    @Override
    public void delete(Board board) throws Exception {
        boardDAO.delete(board);
    }

    @Override
    public List<Board> selectAll() throws Exception {
        return boardDAO.selectAll();
    }

}
