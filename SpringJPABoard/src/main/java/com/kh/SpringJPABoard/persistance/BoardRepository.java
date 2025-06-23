package com.kh.SpringJPABoard.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.SpringJPABoard.domain.Board;

// BoardDAO 대신
public interface BoardRepository extends JpaRepository<Board, Integer>{
}
