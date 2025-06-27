package com.kh.SpringBootSecurity.service;

import java.util.List;

import com.kh.SpringBootSecurity.domain.Member;
import com.kh.SpringBootSecurity.domain.MemberAuth;

public interface MemberDAOService {

    // 회원 삽입
    public void insert(Member member) throws Exception;
    
    // 회원 권한 삽입
    public void insertAuth(MemberAuth memberAuth) throws Exception;

    // 회원 정보 출력
    public Member selectOne(Member member) throws Exception;

    // 회원 정보 출력
    public List<Member> selectAll() throws Exception;

    // 회원 정보, 권한 출력(조인)
    public Member selectJoin(Member member) throws Exception;

    // 회원 정보 수정
    public void update(Member member) throws Exception;

    // 회원 정보 삭제
    public void delete(Member member) throws Exception;

    // 회원 권한 삭제
    public void deleteAuth(Member member) throws Exception;
}
