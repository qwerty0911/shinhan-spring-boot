package com.shinhan.edu;

import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.shinhan.edu.vo.MemberDTO;
import com.shinhan.edu.vo.MemberRole;
import com.shinhan.edu.vo.ProfileDTO;
import com.shinhan.repository.MemberRepository;
import com.shinhan.repository.ProfileRepository;

import lombok.extern.java.Log;


@Log
@SpringBootTest
public class ManyToOneTest {
	
	@Autowired
	ProfileRepository prepo;
	@Autowired
	MemberRepository mRepo;
	
	

	//멤버별 프로필의 수
	@Test
	public void getProfileCount() {
		List<Object[]> result = prepo.getMemberWithProfileCount("manager");
		result.forEach(arr->log.info(Arrays.toString(arr)));
	}
	/*
	@Test
	void addMember() {
		IntStream.range(1, 4).forEach(index->{
			MemberDTO member = MemberDTO.builder()
					.mid("manager"+index)
					.mname("member"+(10+index))
					.mpassword("8888")
					.build();
		});
	}
	
	
	 * //특정 멤버의 profile조회
	@Test
	void getMemberByProfile() {
		Long pno = 110L;
		prepo.findById(pno).ifPresent(p->{
			MemberDTO member = p.getMember();
			log.info(p.isCurrentYn()+" : "+member.getMname() + " ----- "+member.getMrole());
		});
	}
	
	@Test
	void findProfileByMember() {
		
		MemberDTO member = mRepo.findById("user1").orElse(null);
		
		prepo.findByMember(member).forEach(p->log.info("dd"+p.toString()));
		
	}
	
	
	@Test
	void profileInsertTest() {
		//user1의 프로필 5건 생성
		MemberDTO member = mRepo.findById("user1").orElse(null);
		
		if(member!=null) {
			
			log.info("찾은 멤버 : "+member.toString());
			
			IntStream.range(1, 6).forEach(index->{
				ProfileDTO profile = ProfileDTO.builder()
						.fname("face"+index+".jpg")
						.currentYn(index==5?true:false)
						.member(member)
						.build();
				
				prepo.save(profile);
			});
			prepo.findAll().forEach(profile->log.info("프로필log"+profile.toString()));
		}
		
	}
	*/
	
	
}
