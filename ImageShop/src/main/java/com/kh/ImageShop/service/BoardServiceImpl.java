package com.kh.ImageShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ImageShop.domain.Board;
import com.kh.ImageShop.domain.PageRequest;
import com.kh.ImageShop.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper mapper;

    // 게시글 등록 처리
    @Override
    public void register(Board board) throws Exception {
        mapper.create(board);
    }

    // 게시글 목록 페이지
    // @Override
    // public List<Board> list() throws Exception {
    //     return mapper.list();
    // }

    // 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 게시글 목록을 반환한다.
    @Override
    public List<Board> list(PageRequest pageRequest) throws Exception {
        return mapper.list(pageRequest);
    }

    // 게시글 상세 페이지
    @Override
    public Board read(Board board) throws Exception {
        return mapper.read(board);
    }

    // 게시글 수정 처리
    @Override
    public void modify(Board board) throws Exception {
        mapper.update(board);
    }

    // 게시글 삭제 처리
    @Override
    public void remove(Board board) throws Exception {
        mapper.delete(board);
    }

    // 게시글 전체 건수를 반환한다.
    @Override
        public int count(PageRequest pageRequest) throws Exception { 
            return mapper.count(pageRequest);
    }
}
