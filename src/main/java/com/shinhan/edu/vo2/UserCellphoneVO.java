package com.shinhan.edu.vo2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Data
@Table(name="tbl_usercellphone")
public class UserCellphoneVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="phone_id")
	Long phoneId;
	
	String phoneNember;
	String model;
}
