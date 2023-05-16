package com.shinhan.repository;

import org.springframework.data.repository.CrudRepository;

import com.shinhan.edu.vo2.EnumTypeVO;
import com.shinhan.edu.vo3.DeptVO;

public interface DeptRepository extends CrudRepository<DeptVO, Integer>{

}
