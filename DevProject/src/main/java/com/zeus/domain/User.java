package com.zeus.domain;

import java.util.ArrayList;

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
public class User{
    // 멤버 변수
    private String userId;
    private String userName;
    private String userPassword;
    private String userIntroduction;

    private ArrayList<String> cbList;
}
