package com.kh.ImageShop.service;

import java.util.List;

import com.kh.ImageShop.domain.CodeGroup;

public interface CodeGroupService {
    // 등록 처리
    public void register(CodeGroup codeGroup) throws Exception;

    // 목록 페이지
    public List<CodeGroup> list() throws Exception;
}
