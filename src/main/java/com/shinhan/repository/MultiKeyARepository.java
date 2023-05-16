package com.shinhan.repository;

import org.springframework.data.repository.CrudRepository;

import com.shinhan.edu.vo2.MultiKeyA;
import com.shinhan.edu.vo2.MultiKeyAUsing;

public interface MultiKeyARepository extends CrudRepository<MultiKeyAUsing, MultiKeyA>{
	
}
