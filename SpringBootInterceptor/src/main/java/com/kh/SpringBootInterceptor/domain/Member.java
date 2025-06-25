package com.kh.SpringBootInterceptor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
    private String userId;
    private String userPw;
    private String userName;
    private String email;
}
