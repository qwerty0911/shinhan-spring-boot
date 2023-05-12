package com.shinhan.edu;

import java.lang.reflect.Member;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.edu.vo.MemberDTO;
import com.shinhan.edu.vo.MemberRole;
import com.shinhan.repository.MemberRepository;

import lombok.extern.java.Log;


@Log
@SpringBootTest
public class MemberTest {
	
	@Autowired
	MemberRepository repo;
	
	@Test
	void findAllMembers() {
		repo.findAll().forEach(member->{
			System.out.println("!! : "+member);
		});
	}
	/*
	@Test
	void insertTenMembers() {
		//member 10명 입력
		IntStream.rangeClosed(1, 10).forEach(index->{
			MemberDTO member = MemberDTO.builder()
				.mid("user"+index)
				.mname("member"+index)
				.mpassword("1234"+index+index)
				.build();
			if(index<=5) {
				member.setMrole(MemberRole.ADMIN);
			}else {
				member.setMrole(MemberRole.USER);
			}
			repo.save(member);
		});
		
	}
	*/

}
