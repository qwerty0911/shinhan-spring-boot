package com.shinhan.edu.vo2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Data
@Table(name="tbl_usercellphone2")
public class UserCellphoneVO2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="phone_id")
	Long phoneId;
	
	String phoneNember;
	String model;
	
	//대상 테이블에서 참조해보기
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	UserVO2 user;
}
