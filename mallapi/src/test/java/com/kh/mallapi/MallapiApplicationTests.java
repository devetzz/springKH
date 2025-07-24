package com.kh.mallapi;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import com.kh.mallapi.domain.Product;
import com.kh.mallapi.domain.Todo;
import com.kh.mallapi.dto.PageRequestDTO;
import com.kh.mallapi.dto.PageResponseDTO;
import com.kh.mallapi.dto.ProductDTO;
import com.kh.mallapi.repository.ProductRepository;
import com.kh.mallapi.repository.TodoRepository;
import com.kh.mallapi.service.ProductService;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MallapiApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	ProductService productService;

//	@Test
	public void testInsert() {
		for (int i = 1; i <= 100; i++) {
			Todo todo = Todo.builder().title("Title..." + i).dueDate(LocalDate.of(2023, 12, 31)).writer("user00")
					.build();
			todoRepository.save(todo);
		}
	}

//	@Test
	public void productInsert() {
		for (int i = 0; i < 10; i++) {
			Product product = Product.builder().pname("상품" + i).price(100 * i).pdesc("상품설명" + i).build();
			product.addImageString(UUID.randomUUID().toString() + "_" + "image1.jpg");
			product.addImageString(UUID.randomUUID().toString() + "_" + "image2.jpg");
			productRepository.save(product);
		}
	}

	// select (Lazy방식)
//	@Transactional
//	@Test
	public void testRead() {
		Long pno = 1L;
		Optional<Product> result = productRepository.findById(pno);

		Product product = result.orElseThrow();

		log.info(product); // ---------------- 1
		log.info(product.getImageList()); // --------------------------------- 2
	}

	// select (eager 방식)
//	@Test
	public void testRead2() {
		Long pno = 1L;
		Optional<Product> result = productRepository.selectOne(pno);

		Product product = result.orElseThrow();

		log.info(product); // ---------------- 1
		log.info(product.getImageList()); // --------------------------------- 2
	}

//	@Commit
//	@Transactional
//	@Test
	public void testDelete() {
		Long pno = 2L;
		productRepository.updateToDelete(pno, true);
	}

//	@Test
	public void testUpdate() {
		Long pno = 10L;
		Product product = productRepository.selectOne(pno).get();
		product.changeName("10번 상품");
		product.changeDesc("10번 상품 설명입니다.*");
		product.changePrice(55000);

		// 첨부파일 수정
		product.clearList();

		product.addImageString(UUID.randomUUID().toString() + "-" + "NEWIMAGE1.jpg");
		product.addImageString(UUID.randomUUID().toString() + "-" + "NEWIMAGE2.jpg");
		product.addImageString(UUID.randomUUID().toString() + "-" + "NEWIMAGE3.jpg");
		productRepository.save(product);
	}

	// join을 통해 Object[0] : product , Object[1] : productImage 가져온다
//	@Test
	public void testList() {
		// org.springframework.data.domain 패키지
		Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());
		Page<Object[]> result = productRepository.selectList(pageable);
		// java.util
		result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));
	}

//	@Test
	public void testList2() {
		// 1 page, 10 size
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
		PageResponseDTO<ProductDTO> result = productService.getList(pageRequestDTO);
		result.getDtoList().forEach(dto -> log.info(dto));
	}

//	@Test
	public void testRegister() {
		ProductDTO productDTO = ProductDTO.builder().pname("새로운 상품").pdesc("신규 추가 상품입니다.").price(1000).build();
		// uuid가 있어야함
		productDTO.setUploadFileNames(
				java.util.List.of(UUID.randomUUID() + "_" + "Test1.jpg", UUID.randomUUID() + "_" + "Test2.jpg"));
		productService.register(productDTO);
	}

	@Test
	public void testRead3() {
		// 실제 존재하는 번호로 테스트(DB에서 확인)
		Long pno = 9L;
		ProductDTO productDTO = productService.get(pno);
		log.info(productDTO);
		log.info(productDTO.getUploadFileNames());
	}
}
