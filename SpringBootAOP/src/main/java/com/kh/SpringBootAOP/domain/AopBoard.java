package com.kh.SpringBootAOP.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AopBoard {
    private int no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}
