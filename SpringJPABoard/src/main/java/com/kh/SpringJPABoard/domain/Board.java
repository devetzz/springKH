package com.kh.SpringJPABoard.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
// @Table(name="JPABOARD")
// 시퀀스 지정
@SequenceGenerator(name = "BOARD_SEQ_GEN",
        sequenceName = "BOARD_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class Board {
    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GEN")
    // @GeneratedValue
    private int no;
    // @Column(name = "title")
    private String title;
    // @Column(name = "content")
    private String content;
    // @Column(name = "writer")
    private String writer;
    @CreationTimestamp
    @Column(name = "regDate")
    private Date regDate;
}
