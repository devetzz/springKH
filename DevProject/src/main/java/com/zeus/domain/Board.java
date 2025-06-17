package com.zeus.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok annotation
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of={"boardNo","title"})
public class Board{
    // 멤버 변수
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    
}
