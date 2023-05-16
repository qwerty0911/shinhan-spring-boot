package com.shinhan.edu.vo2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="tbl_user2")
public class UserVO2 {
	
	@Id
	@Column(name="user_id")
	String userid;
	
	String username;
	
	//대상 테이블에서 참조해보기
}
