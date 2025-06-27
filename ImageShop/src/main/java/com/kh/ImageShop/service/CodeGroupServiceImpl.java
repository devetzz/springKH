package com.kh.ImageShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ImageShop.domain.CodeGroup;
import com.kh.ImageShop.mapper.CodeGroupMapper;

@Service
public class CodeGroupServiceImpl implements CodeGroupService{

    @Autowired
    private CodeGroupMapper mapper;

    // 등록 처리
    @Override
    public void register(CodeGroup codeGroup) throws Exception {
        mapper.create(codeGroup);
    }

    // 목록 페이지
    @Override
    public List<CodeGroup> list() throws Exception {
        return mapper.list();
    }
}
