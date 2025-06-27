package com.kh.ImageShop.mapper;

import java.util.List;

import com.kh.ImageShop.domain.CodeGroup;

public interface CodeGroupMapper {
    // 등록 처리
    public void create(CodeGroup codeGroup) throws Exception;

    // 목록 페이지
    public List<CodeGroup> list() throws Exception;
}
