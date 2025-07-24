package com.kh.mallapi.dto;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private Long pno;
	private String pname;
	private int price;
	private String pdesc;
	
	@Builder.Default
	// MultipartFile 클라이언트 자료 업로드된 정보를 저장하고 있는 클래스(파일명, 파일사이즈, 파일타입, 파일정보)
	private List<MultipartFile> files = new ArrayList<>();
	
	@Builder.Default
	private List<String> uploadFileNames = new ArrayList<>();
}
