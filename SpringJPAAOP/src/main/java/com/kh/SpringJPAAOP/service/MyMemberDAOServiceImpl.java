package com.kh.SpringJPAAOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.SpringJPAAOP.domain.MyMember;
import com.kh.SpringJPAAOP.persistance.MyMemberRepository;

@Service
public class MyMemberDAOServiceImpl implements MyMemberDAOService{
    @Autowired
    private MyMemberRepository mmr;
    // private MyMemberAuthRepository mmar; 
    // private MyMemberEmailRepository mmer;

    // 회원 , 권한 등록
    @Override
    @Transactional
    public void insert(MyMember member) throws Exception {
        // 회원등록 처리
        mmr.save(member);
        // 회원 권한 생성
        // MyMemberAuth memberAuth = new MyMemberAuth();
        // 회원 권한 설정
        // memberAuth.setNo(member.getNo());
        // memberAuth.setAuth("ROLE_USER");

        // mmar.save(memberAuth);
    }

    // 회원 권한 입력
    // @Override
    // @Transactional
    // public void insertAuth(MyMemberAuth memberAuth) throws Exception {
    //     mmar.save(memberAuth);
    // }

    // // 회원 메일 입력
    // @Override
    // @Transactional
    // public void insertEmail(MyMemberEmail memberEmail) throws Exception {
    //     mmer.save(memberEmail);
    // }

    // 회원 정보 출력
    @Override
    public List<MyMember> selectAll() throws Exception {
        // return mmr.selectAll();
        return mmr.findAll(Sort.by(Direction.DESC, "no"));
    }

    // 회원 정보, 권한 출력(조인)
    @Override
    public MyMember select(MyMember member) throws Exception {
        // return mmr.selectJoin(member);
        return mmr.getOne(member.getNo());
    }

    // 회원 정보 수정
    @Override
    @Transactional
    public void update(MyMember member) throws Exception {
        MyMember myMemberEntity = mmr.getOne(member.getNo());
        myMemberEntity.setId(member.getId());
        myMemberEntity.setPw(member.getPw());
        myMemberEntity.setName(member.getName());
    }

    // 회원 정보 삭제
    @Override
    @Transactional
    public void delete(MyMember member) throws Exception {
        mmr.deleteById(member.getNo());
    }

    // 회원 권한 삭제
    // @Override
    // @Transactional
    // public void deleteAuth(MyMember member) throws Exception {
    //     mmd.deleteAuth(member);
    // }

    // 회원 메일 삭제
    // @Override
    // @Transactional
    // public void deleteEmail(MyMember member) throws Exception {
    //     mmd.deleteEmail(member);
    // }

}
