package com.kh.SpringBootSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.SpringBootSecurity.domain.Member;
import com.kh.SpringBootSecurity.domain.MemberAuth;
import com.kh.SpringBootSecurity.mapper.MemberDAO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService{
    @Autowired
    private MemberDAO mmd;

    // 회원 , 권한 등록
    @Override
    @Transactional
    public void insert(Member member) throws Exception {
        // 회원등록 처리
        mmd.insert(member);
        // 회원 권한 생성
        MemberAuth memberAuth = new MemberAuth();
        // 회원 권한 설정
        memberAuth.setNo(member.getNo());
        memberAuth.setAuth("ROLE_USER");
        mmd.insertAuth(memberAuth);
    }

    // 회원 권한 입력
    @Override
    @Transactional
    public void insertAuth(MemberAuth memberAuth) throws Exception {
        mmd.insertAuth(memberAuth);
    }

    // 회원정보 검색(id)
    @Override
    public Member selectOne(Member member) throws Exception {
        return mmd.selectOne(member);
    }

    // 회원 정보 출력
    @Override
    public List<Member> selectAll() throws Exception {
        return mmd.selectAll();
    }

    // 회원 정보, 권한 출력(조인)
    @Override
    public Member selectJoin(Member member) throws Exception {
        return mmd.selectJoin(member);
    }

    // 회원 정보 수정
    @Override
    @Transactional
    public void update(Member member) throws Exception {
        // 회원정보 수정입력
        mmd.update(member);
        // 회원 권한 삭제
        mmd.deleteAuth(member);

        // 수정된 회원권한 입력
        List<MemberAuth> authList = member.getAuthList();
        for (int i = 0; i < authList.size(); i++) { 
            MemberAuth memberAuth = authList.get(i);
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
    }

    // 회원 정보 삭제
    @Override
    @Transactional
    public void delete(Member member) throws Exception {
        mmd.deleteAuth(member); // 삭제 순서
        mmd.delete(member);
    }

    // 회원 권한 삭제
    @Override
    @Transactional
    public void deleteAuth(Member member) throws Exception {
        mmd.deleteAuth(member);
    }

}
