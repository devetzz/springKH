package com.kh.ImageShop.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CodeLabelValue {
    private final String value;
    private final String label;
}
