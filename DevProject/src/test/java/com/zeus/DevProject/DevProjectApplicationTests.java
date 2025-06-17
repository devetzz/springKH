package com.zeus.DevProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.zeus.domain.Board;

@SpringBootTest
class DevProjectApplicationTests {

	@Test
	void contextLoads() {
		Board board = new Board();
		System.out.println(board.toString());
	}

}
