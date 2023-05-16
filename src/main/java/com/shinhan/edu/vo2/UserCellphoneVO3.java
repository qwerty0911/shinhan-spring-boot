package com.shinhan.edu.vo2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
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
@Table(name="tbl_usercellphone3")
public class UserCellphoneVO3 {
	
	//식별자로 참조하기(참조하는 키를 PK로 사용)
	@Id
	String userid;
	
	@MapsId
	@OneToOne
	@JoinColumn(name="user_id")
	UserVO3 user;
	
	String phoneNember;
	String model;
	
}
