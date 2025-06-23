package com.kh.SpringJPABoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.SpringJPABoard.domain.Board;
import com.kh.SpringJPABoard.persistance.BoardRepository;


@Service
public class BoardDAOServiceImpl implements BoardDAOService{

    @Autowired
    private BoardRepository bd;

    @Override
    @Transactional
    public void insert(Board board) throws Exception {
        bd.save(board);
    }

    @Override
    @Transactional(readOnly = true) // 안쓴거랑 똑같다.
    public Board select(Board board) throws Exception {
        // return bd.select(board);
        return bd.getOne(board.getNo());
    }

    @Override
    @Transactional
    public void update(Board board) throws Exception {
        Board boardEntity = bd.getOne(board.getNo());
        boardEntity.setContent(board.getContent());
        boardEntity.setTitle(board.getTitle());
        boardEntity.setWriter(board.getWriter());
    }

    @Override
    @Transactional
    public void delete(Board board) throws Exception {
        bd.deleteById(board.getNo());
    }

    @Override
    public List<Board> selectAll() throws Exception {
        return bd.findAll(Sort.by(Direction.DESC, "no"));
    }

}
