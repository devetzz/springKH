package com.kh.SpringMybatisProject.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyMember {
    private int no;
    private String id;
    private String pw;
    private String name;
    private int coin;
    private Date regDate;
    private Date updDate;
    private String enabled;
    // 1:N 방식일때 1인 객체에 N인 객체의 List 추가
    private List<MyMemberAuth> authList;
}
