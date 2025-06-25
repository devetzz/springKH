package com.kh.SpringMybatisProject.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MybatisBoard {
    private int no;
    @NotBlank
    private String title;
    private String content;
    private String writer;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date regDate;
}
