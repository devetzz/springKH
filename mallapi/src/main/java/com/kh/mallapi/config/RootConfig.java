package com.kh.mallapi.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

	@Bean
	public ModelMapper getMapper() {
		ModelMapper modelMapper = new ModelMapper();
		// 1. 두개 클래스에서 필드이름이 같으면 매칭
		// 2. 접근제어자 private 매칭
		// 3. LOOSE 전략은 매핑시 필드 이름이 정확히 일치하지 않더라도 비슷한 이름의 필드를 매핑할 수 있게 허용한다
		modelMapper.getConfiguration().setFieldMatchingEnabled(true)
				.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper;
	}

}
