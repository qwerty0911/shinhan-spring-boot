package com.shinhan.edu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;
import com.shinhan.edu.vo.BoardVO;
import com.shinhan.edu.vo.CarVO;
import com.shinhan.edu.vo.QBoardVO;
import com.shinhan.repository.BoardRepository;
import com.shinhan.repository.PDSBoardRepository;
import com.shinhan.repository.PDSFileRepository;

import lombok.extern.java.Log;

@Log
@RestController //@Controller+@ResponseBody->@responsebody.getWriter().append("jsp/servlet")
public class SampleRestController {
	
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	PDSFileRepository fileRepo;
	@Autowired
	PDSBoardRepository pdsboardRepo;
	
	
	@GetMapping("/monday")
	String fileUPdate() {
		int result = pdsboardRepo.updateFile(10L, "머릿말(수정2)");
		return "OK : "+result;
	}
	
	
	@GetMapping("/sunday")
	public List<BoardVO> dynamicSQLTest() {
		String title= ""; 	//where title like '%9%'
		Long bno = 1L; 	//where bno>50
		String writer = "11";
		
		BooleanBuilder builder = new BooleanBuilder();
		QBoardVO  board = QBoardVO.boardVO;
		builder.and(board.content.like("%"+title+"%"));
		builder.and(board.bno.gt(bno));
		builder.and(board.writer.like("%"+writer+"%"));
		
		List<BoardVO> boardList = (List<BoardVO>)boardRepository.findAll(builder);
		
		return boardList;
	}
	
	
	
	@GetMapping("/friday")
	public Map<String, Object> sample1() {
		long rowCount = boardRepository.count();
		log.info("board는 "+rowCount+"개이다.");
		
		boolean result = boardRepository.existsById(100L);
		log.info(result?"존재":"존재하지않아");
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("aa", rowCount + "건");
		map.put("bb", result?"ex":"None");
		map.put("data", boardRepository.findById(88l).orElse(null));
		return map;
	}
	
	@GetMapping("/cartest")
	public List<CarVO> cartest() { //Jackson이 JAVA객체를 JSON으로 만들어서 return 해줌
		
		List<CarVO> carList = new ArrayList<>();
		
		IntStream.rangeClosed(1, 10).forEach(index->{
			CarVO car1 = CarVO.builder()
					.model("c"+index*100)
					.price(5000+index*100)
					.build();
			carList.add(car1);
		});
		
		
		
		return carList;
	}
	
	@GetMapping("/sample1")
	public String test1() {
		
		return "SpringBoot 열공";
	}
	
	@GetMapping("/sample2")
	public String test2() {
		
		return "SpringBoot 화이팅 해보자잇!";
	}
	
	
}
