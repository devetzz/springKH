package com.kh.SpringJPAAOP.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.SpringJPAAOP.domain.MyMember;

public interface MyMemberRepository extends JpaRepository<MyMember, Integer>{
}
