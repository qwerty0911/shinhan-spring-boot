package com.shinhan.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.edu.vo2.UserCellphoneVO;
import com.shinhan.edu.vo2.UserCellphoneVO2;
import com.shinhan.edu.vo2.UserCellphoneVO3;
import com.shinhan.edu.vo2.UserVO2;
import com.shinhan.edu.vo2.UserVO3;
import com.shinhan.repository.CellphoneVORepository2;
import com.shinhan.repository.UserREpository2;
import com.shinhan.repository.UserREpository3;
import com.shinhan.repository.UserRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class UserCellphoneTest2 {
	
	@Autowired
	UserREpository2 uRepo;
	@Autowired
	CellphoneVORepository2 pRepo;
	
	@Autowired
	UserREpository3 urepo3;
	
	@Test
	public void test3() {
		UserCellphoneVO3 phone = UserCellphoneVO3.builder()
				.phoneNember("010-1234-4321")
				.model("iphone")
				.build();
		
		UserVO3 user = UserVO3.builder()
				.userid("user1")
				.username("username1")
				.phone(phone)
				.build();
		
		phone.setUser(user);
		urepo3.save(user);
	}
	/*
	@Test
	public void test() {
		UserVO2 user = UserVO2.builder()
				.userid("user1")
				.username("username1")
				.build();
		
		UserCellphoneVO2 phone = UserCellphoneVO2.builder()
				.phoneNember("010-1234-4321")
				.model("s23")
				.user(user)
				.build();
		
		pRepo.save(phone);
	}
	*/
}
