package com.zeus.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok annotation
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CodeLabelValue{
    // 멤버 변수
    private String label;
    private String value;
}
