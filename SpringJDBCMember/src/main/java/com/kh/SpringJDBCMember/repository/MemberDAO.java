package com.kh.SpringJDBCMember.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.SpringJDBCMember.domain.Member;

@Repository
public class MemberDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String insertMember = "INSERT INTO MEMBER (NO, ID, PWD, NAME) VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?)";
    private String selectByNoMember = "SELECT NO, ID, PWD, NAME, REG_DATE FROM MEMBER WHERE NO = ?";
    private String updateMember = "UPDATE MEMBER SET ID=?, PWD=?, NAME=? WHERE NO=?";
    private String deleteMember = "DELETE FROM MEMBER WHERE NO=?";
    private String selectMember = "SELECT NO, ID, PWD, NAME, REG_DATE FROM MEMBER WHERE NO > 0 ORDER BY NO DESC, REG_DATE DESC";

    // 게시판 삽입
    public void insert(Member member) throws Exception{
        jdbcTemplate.update(insertMember, member.getId(), member.getPwd(), member.getName());
    }

    // 게시판 출력(one)
    public Member select(Member member) throws Exception{
        List<Member> result = jdbcTemplate.query(selectByNoMember, new RowMapper<Member>(){

            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member = new Member();
                member.setNo(rs.getInt("NO"));
                member.setId(rs.getString("ID"));
                member.setPwd(rs.getString("PWD"));
                member.setName(rs.getString("NAME"));
                member.setRegDate(rs.getDate("reg_date"));

                return member;
            }
            
        }, member.getNo());

        return result.isEmpty() ? null : result.get(0);
    }

    // 게시판 수정
    public void update(Member member) throws Exception{
        jdbcTemplate.update(updateMember, member.getId(), member.getPwd(), member.getName(), member.getNo());
    }

    // 게시판 삭제
    public void delete(Member member) throws Exception{
        jdbcTemplate.update(deleteMember, member.getNo());
    }

    // 게시판 전체 출력
    public List<Member> selectAll() throws Exception{
        List<Member> result = jdbcTemplate.query(selectMember, new RowMapper<Member>() {

            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member = new Member();
                member.setNo(rs.getInt("NO"));
                member.setId(rs.getString("ID"));
                member.setPwd(rs.getString("PWD"));
                member.setName(rs.getString("NAME"));
                member.setRegDate(rs.getDate("reg_date"));

                return member;
            }
            
        });

        return result.isEmpty() ? null : result;
    }

}
