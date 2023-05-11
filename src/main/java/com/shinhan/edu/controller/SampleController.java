package com.shinhan.edu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.edu.vo.CarVO;

@RestController //@Controller+@ResponseBody->@responsebody.getWriter().append("jsp/servlet")
public class SampleController {
	
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
