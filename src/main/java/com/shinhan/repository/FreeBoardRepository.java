package com.shinhan.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.shinhan.edu.vo.FreeBoard;

public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long>{
	
	List<FreeBoard> findByBnoGreaterThan(Long bno, Pageable page);

}
