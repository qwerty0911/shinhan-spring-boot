package com.shinhan.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.edu.vo2.UserCellphoneVO;
import com.shinhan.edu.vo2.UserVO;
import com.shinhan.repository.CellphoneVORepository;
import com.shinhan.repository.UserRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class UserCellphoneTest {
	
	@Autowired
	UserRepository uRepo;
	@Autowired
	CellphoneVORepository pRepo;
	
	@Test
	public void test() {
		UserCellphoneVO phone = UserCellphoneVO.builder()
				.phoneNember("010-1234-4321")
				.model("s23")
				.build();
		UserCellphoneVO savedCellphone = pRepo.save(phone);
		
		UserVO user = UserVO.builder()
				.userid("user1")
				.username("username1")
				.phone(savedCellphone)
				.build();
		
		uRepo.save(user);
	}
}
