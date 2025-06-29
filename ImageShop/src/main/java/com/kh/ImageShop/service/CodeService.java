package com.kh.ImageShop.service;

import java.util.List;

import com.kh.ImageShop.common.CodeLabelValue;

public interface CodeService {
    // 그룹코드 목록 조회
    public List<CodeLabelValue> getCodeGroupList() throws Exception;
}
