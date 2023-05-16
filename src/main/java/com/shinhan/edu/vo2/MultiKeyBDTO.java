package com.shinhan.edu.vo2;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="tbl_child2")
@Builder @NoArgsConstructor @AllArgsConstructor
public class MultiKeyBDTO {
	
	@EmbeddedId
	MultiKeyB id;
	
	private String userName;
	private String address;
}
