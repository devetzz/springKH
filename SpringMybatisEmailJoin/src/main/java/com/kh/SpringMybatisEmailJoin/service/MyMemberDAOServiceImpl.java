package com.kh.SpringMybatisEmailJoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.SpringMybatisEmailJoin.domain.MyMember;
import com.kh.SpringMybatisEmailJoin.domain.MyMemberAuth;
import com.kh.SpringMybatisEmailJoin.domain.MyMemberEmail;
import com.kh.SpringMybatisEmailJoin.mapper.MyMemberDAO;

@Service
public class MyMemberDAOServiceImpl implements MyMemberDAOService{
    @Autowired
    private MyMemberDAO mmd;

    // 회원 , 권한 등록
    @Override
    @Transactional
    public void insert(MyMember member) throws Exception {
        // 회원등록 처리
        mmd.insert(member);
        // 회원 권한 생성
        MyMemberAuth memberAuth = new MyMemberAuth();
        // 회원 권한 설정
        memberAuth.setNo(member.getNo());
        memberAuth.setAuth("ROLE_USER");

        mmd.insertAuth(memberAuth);
    }

    // 회원 권한 입력
    @Override
    @Transactional
    public void insertAuth(MyMemberAuth memberAuth) throws Exception {
        mmd.insertAuth(memberAuth);
    }

    // 회원 메일 입력
    @Override
    @Transactional
    public void insertEmail(MyMemberEmail memberEmail) throws Exception {
        mmd.insertEmail(memberEmail);
    }

    // 회원 정보 출력
    @Override
    public List<MyMember> selectAll() throws Exception {
        return mmd.selectAll();
    }

    // 회원 정보, 권한 출력(조인)
    @Override
    public MyMember selectJoin(MyMember member) throws Exception {
        return mmd.selectJoin(member);
    }

    // 회원 정보 수정
    @Override
    @Transactional
    public void update(MyMember member) throws Exception {
        // 회원정보 수정입력
        mmd.update(member);
        // 회원 권한 삭제
        mmd.deleteAuth(member);
        mmd.deleteEmail(member);

        // 수정된 회원권한 입력
        List<MyMemberAuth> authList = member.getAuthList();
        for (int i = 0; i < authList.size(); i++) { 
            MyMemberAuth memberAuth = authList.get(i);
            String auth = memberAuth.getAuth();
            if (auth == null) {
                continue;
            }
            if (auth.trim().length() == 0) { 
                continue;
            }
            memberAuth.setNo(member.getNo());
            mmd.insertAuth(memberAuth);
        }

        List<MyMemberEmail> emailList = member.getEmailList();
        for (int i = 0; i < emailList.size(); i++) { 
            MyMemberEmail memberEmail = emailList.get(i);
            String email = memberEmail.getEmail();
            if (email == null) {
                continue;
            }
            if (email.trim().length() == 0) { 
                continue;
            }
            memberEmail.setNo(member.getNo());
            mmd.insertEmail(memberEmail);
        }
    }

    // 회원 정보 삭제
    @Override
    @Transactional
    public void delete(MyMember member) throws Exception {
        mmd.deleteAuth(member); // 삭제 순서
        mmd.deleteEmail(member);
        mmd.delete(member);
    }

    // 회원 권한 삭제
    @Override
    @Transactional
    public void deleteAuth(MyMember member) throws Exception {
        mmd.deleteAuth(member);
    }

    // 회원 메일 삭제
    @Override
    @Transactional
    public void deleteEmail(MyMember member) throws Exception {
        mmd.deleteEmail(member);
    }

}
