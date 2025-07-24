package com.kh.mallapi.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;

@Component
@Log4j2
@RequiredArgsConstructor
public class CustomFileUtil {

	@Value("${com.kh.upload.path}")
	private String uploadPath;

	@PostConstruct
	// 파일 업로드용 폴더가 없으면 자동으로 생성하는 초기화 로직
	// 생성자 → 의존성 주입(DI) → @PostConstruct 메서드 실행
	// uploadPath 값이 주입된 이후에 실행됨.
	// init() : 업로드할 파일이 저장된 폴더 위치를 uploadPath에 저장하는 설정 함수
	public void init() {
		File tempFolder = new File(uploadPath);
		if (tempFolder.exists() == false) {
			tempFolder.mkdir();
		}
		uploadPath = tempFolder.getAbsolutePath();
		log.info(" ");
		log.info(uploadPath);
	}

	public List<String> saveFiles(List<MultipartFile> files) throws RuntimeException {
		if (files == null || files.size() == 0) {
			return null;
		}
		// MultipartFile : 사용자가 업로드한 파일 정보가 들어있는 객체
		List<String> uploadNames = new ArrayList<>();
		for (MultipartFile multipartFile : files) {
			// UUID_KDJ.jpg
			String savedName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
			Path savePath = Paths.get(uploadPath, savedName);
			try {
				// 사용자가 올린 UUID_KDJ.jpg -> uploadPath에 복사
				Files.copy(multipartFile.getInputStream(), savePath);

				// 업로드한 파일이 이미지 파일인지 체크
				String contentType = multipartFile.getContentType();
				if (contentType != null && contentType.startsWith("image")) {
					Path thumbnailPath = Paths.get(uploadPath, "s_" + savedName);
					// savePath에 있는 파일을 400x400px로 만들어서 s_파일명 파일로 저장
					Thumbnails.of(savePath.toFile()).size(400, 400).toFile(thumbnailPath.toFile());
				}
				// List<String> UploadNames에 실제 저장되어 있는 파일경로 문자열 저장
				uploadNames.add(savedName);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		} // end for
		return uploadNames;
	}

	public ResponseEntity<Resource> getFile(String fileName) {
		Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);
		if (!resource.exists()) {
			resource = new FileSystemResource(uploadPath + File.separator + "default.gif");
		}
		HttpHeaders headers = new HttpHeaders();
		try {
			// Files.probeContentType()은 파일 경로를 분석하여 MIME 타입을 자동 감지 jpg → image/jpeg, png →
			// //image/pngpdf → application/pdf 이 정보를 HTTP 응답 헤더에 Content-Type으로 추가한다
			headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.ok().headers(headers).body(resource);
	}

	public void deleteFiles(List<String> fileNames) {
		if (fileNames == null || fileNames.size() == 0) {
			return;
		}
		fileNames.forEach(fileName -> {
			// 썸네일이 있는지 확인하고 삭제
			String thumbnailFileName = "s_" + fileName;
			Path thumbnailPath = Paths.get(uploadPath, thumbnailFileName);
			Path filePath = Paths.get(uploadPath, fileName);
			try {
				Files.deleteIfExists(filePath);
				Files.deleteIfExists(thumbnailPath);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		});
	}
}
