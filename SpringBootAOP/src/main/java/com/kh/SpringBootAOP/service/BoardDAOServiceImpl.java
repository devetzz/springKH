package com.kh.SpringBootAOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.SpringBootAOP.domain.AopBoard;
import com.kh.SpringBootAOP.mapper.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardDAOServiceImpl implements BoardDAOService{

    @Autowired
    private BoardDAO bd;

    @Override
    @Transactional
    public void insert(AopBoard board) throws Exception {
        
        log.info("start Log insert");
        bd.insert(board);
    }

    @Override
    @Transactional(readOnly = true) // 안쓴거랑 똑같다.
    public AopBoard select(AopBoard board) throws Exception {
        // return bd.select(board);
        log.info("start Log select");
        return bd.select(board);
    }

    @Override
    @Transactional
    public void update(AopBoard board) throws Exception {
        log.info("start Log update");
        bd.update(board);
    }

    @Override
    @Transactional
    public void delete(AopBoard board) throws Exception {
        log.info("start Log delete");
        bd.delete(board);;
    }

    @Override
    public List<AopBoard> selectAll() throws Exception {
        log.info("start Log selectAll");
        return bd.selectAll();
    }

}
