package com.zeus.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
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
public class Member{
    // 멤버 변수
    private String userId;
    private String password;
    // Date 타입 필드 변환 처리
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date dateOfBirth;
    private List<String> nationality;

    private Board board;
    private List<MultipartFile> picture;

    private String gender;
}
