package com.shinhan.edu.vo2;

import javax.persistence.CascadeType;
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
@Table(name="tbl_user3")
public class UserVO3 {
	
	@Id
	@Column(name="user_id")
	String userid;
	String username;
	
	//양방향...키를 식별자가 사용하는 경우
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	UserCellphoneVO3 phone;
}
