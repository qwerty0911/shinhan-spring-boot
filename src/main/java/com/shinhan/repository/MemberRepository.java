package com.shinhan.repository;

import org.springframework.data.repository.CrudRepository;

import com.shinhan.edu.vo.MemberDTO;

public interface MemberRepository extends CrudRepository<MemberDTO, String>{
	
	

}
