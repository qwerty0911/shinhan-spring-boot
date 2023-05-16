package com.shinhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shinhan.edu.vo.FreeBoard;
import com.shinhan.edu.vo.FreeBoardReply;

public interface FreeRepliesRepository extends CrudRepository<FreeBoardReply, Long>{
	
	
	@Query
	public List<FreeBoard> findByBoard(FreeBoard board);
}
