package com.kh.ImageShop.mapper;

import java.util.List;

import com.kh.ImageShop.domain.CodeLabelValue;

public interface CodeMapper {
    // 그룹코드 목록 조회
    public List<CodeLabelValue> getCodeGroupList() throws Exception;

    public List<CodeLabelValue> getCodeList(String groupCode) throws Exception;
}
