package com.shinhan.repository;

import org.springframework.data.repository.CrudRepository;

import com.shinhan.edu.vo2.UserVO;

public interface UserRepository extends CrudRepository<UserVO, Long>{

}
