package com.shinhan.edu;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import com.shinhan.edu.vo.BoardVO;
import com.shinhan.edu.vo.CarVO;
import com.shinhan.repository.BoardRepository;

/*junit으로 단위테스트*/
@SpringBootTest
class SpringBootPjtApplicationTests {
	
	Logger LOGGER = LoggerFactory.getLogger(SpringBootPjtApplicationTests.class);
	@Autowired
	BoardRepository boardRepository;
	/*
	@Test
	void test1() {
		CarVO car1 = new CarVO();
		car1.setModel("c-200");
		car1.setPrice(5000);
		
		CarVO car2 = new CarVO();
		car2.setModel("c-200");
		car2.setPrice(5000);
		
		Assertions.assertThat(car1.getModel()).isEqualTo("c-200");
		//LOGGER.info(car1.toString()); *
	}
	
	@Test
	void test2() {
		CarVO car1 = CarVO.builder()
				.model("c-200d")
				.price(4500)
				.build();
		
		Assertions.assertThat(car1.getModel()).isEqualTo("c-200d");
	}
	@Test
	public void repositoryTest() {
		IntStream.rangeClosed(1, 100).forEach(i->{
			BoardVO board = BoardVO.builder()
					.title("title"+i)
					.content("content...."+i)
					.writer("writer"+1+i%10)
					.build();
			boardRepository.save(board); //save함수
		});
		
		
	}
	@Test
	public void repositoryFindAllTest() {
		 boardRepository.findAll().forEach(board->{
			 LOGGER.info(board.toString());
		 });
	}
	
	@Test
	public void repositoryFindByIdTest() {
		BoardVO board = boardRepository.findById(30L).orElse(null);
		LOGGER.info(board.toString());
	}
	
	@Test
	public void repositoryFindAndModified() {
		BoardVO board = boardRepository.findById(10L).orElse(null);
		int updateCount;
		if(board!=null) {
			board.setContent("내용수정");
			board.setTitle("수정된 title");
			boardRepository.save(board); //이미 있는 data는 update
		}
		
	}
	
	@Test
	public void testcondition() {
		List<BoardVO> bList = boardRepository.findByTitle("title1");
		bList.forEach(board->{
			System.out.println(board);
		});
	}
	
	@Test
	public void testcondition2() {
		List<BoardVO> bList = boardRepository.findByWriterAndTitle("writer11", "title1");
		bList.forEach(board->{
			System.out.println(board);
		});
	}
	
	@Test
	void contextLoads() {
	}*/
	
	@Test
	public void testcondition2() {
		List<BoardVO> bList = boardRepository.findByTitleContaining("9");
		bList.forEach(board->{
			System.out.println(board);
		});
	}

}
