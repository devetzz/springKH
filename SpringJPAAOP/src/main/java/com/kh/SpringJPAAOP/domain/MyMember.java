package com.kh.SpringJPAAOP.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MyMember {
    @Id
    @GeneratedValue
    private int no;
    private String id;
    private String pw;
    private String name;
    @CreationTimestamp
    private Date regDate;
    @UpdateTimestamp
    private Date updDate;
}
