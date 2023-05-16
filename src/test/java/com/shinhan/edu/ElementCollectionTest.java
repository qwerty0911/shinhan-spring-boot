package com.shinhan.edu;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.edu.vo.MemberRole;
import com.shinhan.edu.vo2.EnumTypeVO;
import com.shinhan.repository.EnumTypeRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class ElementCollectionTest {
	
	@Autowired
	EnumTypeRepository repo;
	
	
	@Test
	void test3() {
		repo.findById("123").ifPresent(member->{
			log.info(member.getMrole().toString());
			
		});
	}
	
	/*
	@Test
	void test2() {
		repo.findAll().forEach(member->{
			log.info(member.toString());
		});
	}
	
	@Test
	void test1() {
		Set<MemberRole> mrole = new HashSet<>();
		//mrole.add(MemberRole.ADMIN);
		//mrole.add(MemberRole.MANAGER);
		mrole.add(MemberRole.USER);
		
		EnumTypeVO vo = EnumTypeVO.builder()
				.mid("124")
				.mname("user2")
				.mpassword("pass12")
				.mrole(mrole)
				.build();
		repo.save(vo);
	}
	*/

}
