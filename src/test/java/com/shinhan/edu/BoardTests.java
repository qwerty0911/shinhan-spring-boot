package com.shinhan.edu;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.querydsl.core.BooleanBuilder;
import com.shinhan.edu.vo.BoardVO;
import com.shinhan.edu.vo.CarVO;
import com.shinhan.edu.vo.QBoardVO;
import com.shinhan.repository.BoardRepository;

import lombok.extern.java.Log;

/*junit으로 단위테스트*/
@SpringBootTest
@Log
class BoardTests {

	Logger LOGGER = LoggerFactory.getLogger(BoardTests.class);
	@Autowired
	BoardRepository boardRepository;

	
	
	/*
	@Test
	void dynamicSQLTest() {
		String title= "9"; 	//where title like '%9%'
		Long bno = 50L; 	//where bno>50
		String writer = "1";
		
		BooleanBuilder builder = new BooleanBuilder();
		QBoardVO  board = QBoardVO.boardVO;
		builder.and(board.content.like("%"+title+"%"));
		builder.and(board.bno.gt(bno));
		builder.and(board.writer.eq(writer));
		
		List<BoardVO> boardList = (List<BoardVO>)boardRepository.findAll(builder);
	}
	
	/*
	@Test
	void test9NativeQuery() {
		List<BoardVO> boardList = boardRepository.findByTitle6("9", "1");
		
		boardList.forEach(board->{
			log.warning(board.toString());
		});
	}
	
	void test8() {
		List<BoardVO> boardList = boardRepository.findByTitle4("9", "1");
		
		boardList.forEach(board->{
			log.info("log : "+board.toString());
		});
	}
	
	void test7() {
		List<BoardVO> boardList = boardRepository.findByTitle3("9", "1");
		
		boardList.forEach(board->{
			log.info("log : "+board.toString());
		});
	}
	
	
	void test6() {
		List<BoardVO> boardList = boardRepository.findByTitle2("9", "1");
		
		boardList.forEach(board->{
			log.info("log : "+board.toString());
		});
	}
	
	
	void sample5() {
		//Sort sort = Sort.by("bno").descending();
		
		//order by writer DESC, BNO DESC
		Sort sort = Sort.by(Sort.Direction.DESC, new String[] {"writer","bno"});
		Pageable paging = PageRequest.of(2, 5, sort);
		
		Page<BoardVO> result = boardRepository.findByBnoGreaterThan(100L, paging);
		log.info("페이지당 건수 : "+result.getSize());
		log.info("페이지당 총 수 : "+result.getTotalPages());
		log.info("전체 건 수 : "+result.getTotalElements());
		List<BoardVO> boardList = result.getContent();
		
		boardList.forEach(board->{
			log.info("log : "+board.toString());
		});
	}
	
	void sample4() {
		//Sort sort = Sort.by("bno").descending();
		
		//order by writer DESC, BNO DESC
		Sort sort = Sort.by(Sort.Direction.DESC, new String[] {"writer","bno"});
		Pageable paging = PageRequest.of(2, 5, sort);
		List<BoardVO> boards = boardRepository.findByTitleContaining("title", paging);
		boards.forEach(board->{
			log.info("log : "+board.toString());
		});
	}
	
	void sample3() {
		Pageable paging = PageRequest.of(1, 10);
		 List<BoardVO> boards = boardRepository.findByTitleContainingOrderByTitleDesc("title", paging);
		 boards.forEach(board->{
			 log.info("log : "+board.toString());
		 });
	}
	
	void sample2() {
		 List<BoardVO> boards = boardRepository.findByTitleContainingOrderByTitleDesc("title");
		 boards.forEach(board->{
			 log.info("log : "+board.toString());
		 });
	}
	
	
	void sample1() {
		long logCount = boardRepository.count();
		log.info("board는 "+logCount+"개이다.");
		
		boolean result = boardRepository.existsById(100L);
		log.info(result?"존재":"존재하지않아");
	}
	
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
		bList.forEach(board -> {
			System.out.println(board);
		});
	}
}
