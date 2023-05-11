package com.shinhan.repository;

import org.springframework.data.repository.CrudRepository;

import com.shinhan.edu.vo.JobVO;

public interface JobRepository extends CrudRepository<JobVO, String>{

}
