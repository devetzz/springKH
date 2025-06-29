package com.kh.ImageShop.mapper;

import java.util.List;

import com.kh.ImageShop.common.CodeLabelValue;

public interface CodeMapper {
    // 그룹코드 목록 조회
    public List<CodeLabelValue> getCodeGroupList() throws Exception;
}
