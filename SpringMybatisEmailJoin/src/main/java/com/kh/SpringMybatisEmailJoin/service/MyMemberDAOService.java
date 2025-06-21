package com.kh.SpringMybatisEmailJoin.service;

import java.util.List;

import com.kh.SpringMybatisEmailJoin.domain.MyMember;
import com.kh.SpringMybatisEmailJoin.domain.MyMemberAuth;

public interface MyMemberDAOService {

    // 회원 삽입
    public void insert(MyMember member) throws Exception;
    
    // 회원 권한 삽입
    public void insertAuth(MyMemberAuth memberAuth) throws Exception;

    // 회원 정보 출력
    public List<MyMember> selectAll() throws Exception;

    // 회원 정보, 권한 출력(조인)
    public MyMember selectJoin(MyMember member) throws Exception;

    // 회원 정보 수정
    public void update(MyMember member) throws Exception;

    // 회원 정보 삭제
    public void delete(MyMember member) throws Exception;

    // 회원 권한 삭제
    public void deleteAuth(MyMember member) throws Exception;
}
