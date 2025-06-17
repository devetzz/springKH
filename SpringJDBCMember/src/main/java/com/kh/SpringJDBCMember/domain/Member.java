package com.kh.SpringJDBCMember.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
    private int no;
    private String id;
    private String pwd;
    private String name;
    private Date regDate;
}
