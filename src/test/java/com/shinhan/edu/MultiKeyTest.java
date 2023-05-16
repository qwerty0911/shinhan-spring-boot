package com.shinhan.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.edu.vo2.MultiKeyAUsing;
import com.shinhan.edu.vo2.MultiKeyB;
import com.shinhan.edu.vo2.MultiKeyBDTO;
import com.shinhan.repository.MultiKeyARepository;
import com.shinhan.repository.MultiKeyBRepository;

@SpringBootTest
public class MultiKeyTest {
	
	@Autowired
	MultiKeyARepository aRepo;
	@Autowired
	MultiKeyBRepository bRepo;
	
	@Test
	void test2() {
		MultiKeyB id = MultiKeyB.builder()
				.id1(10)
				.id2(21)
				.build();
		
		MultiKeyBDTO b = MultiKeyBDTO.builder()
				.id(id)
				.userName("user2")
				.address("dobong")
				.build();
		bRepo.save(b);
	}
	
	/*
	@Test
	void test1() {
		MultiKeyAUsing a = new MultiKeyAUsing();
		a.setId1(1);
		a.setId2(2);
		a.setUserName("jin1");
		a.setAddress("nowon");
		repo.save(a);
	}
	*/
}
