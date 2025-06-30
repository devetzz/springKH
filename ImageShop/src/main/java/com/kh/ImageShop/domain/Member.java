package com.kh.ImageShop.domain;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int userNo;

    @NotBlank
    private String userId;

    @NotBlank
    private String userPw;
    
    @NotBlank
    private String userName;
    private String job;
    private int coin;
    private boolean enabled;
    private Date regDate;
    private Date updDate;
    private List<MemberAuth> authList;
}
