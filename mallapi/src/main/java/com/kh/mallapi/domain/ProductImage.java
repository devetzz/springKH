package com.kh.mallapi.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable	// 1 : n 에서 n에 사용, ProductDTO.pno FK
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
	private String fileName;
	private int ord;	// 이미지 순서 본이미지(0), 서브이미지(1~4...)

	public void setOrd(int ord) {
		this.ord = ord;
	}
}
