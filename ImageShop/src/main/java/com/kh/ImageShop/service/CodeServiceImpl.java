package com.kh.ImageShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ImageShop.common.CodeLabelValue;
import com.kh.ImageShop.mapper.CodeMapper;

@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private CodeMapper mapper;

    // 그룹코드 목록 조회 구현
    @Override
    public List<CodeLabelValue> getCodeGroupList() throws Exception {
        return mapper.getCodeGroupList();
    }
}
